package com.uds.horbac.core.rest.units;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uds.horbac.core.dao.units.AdministrativeUnitRepository;
import com.uds.horbac.core.dao.units.OperationalUnitRepository;
import com.uds.horbac.core.dao.units.UnitNodeRepository;
import com.uds.horbac.core.dto.units.UnitNodeDTO;
import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.entities.permissions.ApprovalType;
import com.uds.horbac.core.entities.requests.AccessRequest;
import com.uds.horbac.core.entities.requests.AppResponse;
import com.uds.horbac.core.entities.units.*;
import com.uds.horbac.core.entities.users.Approver;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.service.users.UserService;
import com.uds.horbac.integration.ApprovalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.contexts.DefineDTO;
import com.uds.horbac.core.dto.units.PlaceUnderDTO;
import com.uds.horbac.core.dto.units.SubordinateDTO;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.exceptions.ApiException;
import com.uds.horbac.core.service.organizations.OrganizationService;
import com.uds.horbac.core.service.units.OrgTreeService;
import com.uds.horbac.core.service.units.PlaceUnderService;
import com.uds.horbac.core.service.units.SubordinateService;

@RestController
public class UnitsAssociationController {
    protected @Autowired SubordinateService subService;
    protected @Autowired PlaceUnderService underService;
    protected @Autowired OrgTreeService orgTreeService;
    protected @Autowired OrganizationService orgService;

    protected @Autowired ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    ApprovalService approvalService;

    @Autowired
    UnitNodeRepository unitNodeRepository;
    @Autowired
    private AdministrativeUnitRepository administrativeUnitRepository;
    @Autowired
    private OperationalUnitRepository operationalUnitRepository;

    @GetMapping(value = "/place-unders")
    public List<PlaceUnderDTO> getAllPlaceUnders(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return underService.getAll().stream()
                .map(def -> modelMapper.map(def, PlaceUnderDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/place-unders/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PlaceUnderDTO getOnePlaceUnderById(@PathVariable Long id) {
        return modelMapper.map(underService.getPlaceUnder(id), PlaceUnderDTO.class);
    }

    @PostMapping("/place-unders")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PlaceUnderDTO create(@Valid @RequestBody PlaceUnderDTO defDTO) {
        PlaceUnder def = modelMapper.map(defDTO, PlaceUnder.class);
        return modelMapper.map(underService.save(def), PlaceUnderDTO.class);
    }

    @PutMapping("/place-unders")
    @ResponseStatus(value = HttpStatus.OK)
    public PlaceUnderDTO updatePlaceUnder(@Valid @RequestBody PlaceUnderDTO defDTO) {
        PlaceUnder def = modelMapper.map(defDTO, PlaceUnder.class);
        return modelMapper.map(underService.save(def), PlaceUnderDTO.class);
    }

    @DeleteMapping(value = "/place-unders/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePlaceUnder(@PathVariable Long id) {
        underService.delete(id);
    }

    @PostMapping("/place-unders/many")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<PlaceUnderDTO> createManyPlaceUnders(@Valid @RequestBody List<PlaceUnderDTO> defDTOs) {
        List<PlaceUnder> subs = defDTOs.stream()
                .map(def -> modelMapper.map(def, PlaceUnder.class))
                .collect(Collectors.toList());

        return underService.saveAll(subs).stream()
                .map(def -> modelMapper.map(def, PlaceUnderDTO.class))
                .collect(Collectors.toList());
    }


    /*
     * Subordinates entry points
     */

    @GetMapping(value = "/subordinates")
    public List<SubordinateDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return subService.getAll().stream()
                .map(def -> modelMapper.map(def, SubordinateDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/subordinates/{id}")
    public SubordinateDTO getOneById(@PathVariable Long id) {
        return modelMapper.map(subService.getOne(id), SubordinateDTO.class);
    }

    @PostMapping("/subordinates")
    @ResponseStatus(value = HttpStatus.CREATED)
    public SubordinateDTO create(@Valid @RequestBody SubordinateDTO defDTO) {
        Subordinate def = modelMapper.map(defDTO, Subordinate.class);
        def = subService.save(def);
        return modelMapper.map(def, SubordinateDTO.class);
    }

    @PostMapping("/subordinates/many")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<SubordinateDTO> createMany(@Valid @RequestBody List<SubordinateDTO> defDTOs) {
        List<Subordinate> subs = defDTOs.stream()
                .map(def -> modelMapper.map(def, Subordinate.class))
                .collect(Collectors.toList());

        return subService.saveAll(subs).stream()
                .map(def -> modelMapper.map(def, SubordinateDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/subordinates")
    @ResponseStatus(value = HttpStatus.OK)
    public SubordinateDTO updateDefine(@Valid @RequestBody DefineDTO defDTO) {
        Subordinate def = modelMapper.map(defDTO, Subordinate.class);
        return modelMapper.map(subService.save(def), SubordinateDTO.class);
    }

    @DeleteMapping(value = "/subordinates/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        subService.delete(id);
    }

    @GetMapping(value = "/tree/organization/{id}")
    public ResponseEntity<OrgTree> getOrgTree(@PathVariable Long id) {
        Organization org = orgService.getOrganization(id);
        if (org == null) {
            throw new ApiException("organization with id " + id + " not found");
        }

        OrgTree res = orgTreeService.getOrgTree(org);
        traverse(res);
        return ResponseEntity.ok(res);
    }


    @GetMapping(value = "/units-nodes/with-approval/{id}")
    public List<UnitNodeDTO> getUnitsWithApproval(@PathVariable Long id) {
        return unitNodeRepository.findAllByOrganizationId(id).stream()
                .map(def -> modelMapper.map(def, UnitNodeDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/units-nodes/with-approval/{id}")
    public boolean RegisterUnitsWithApproval(@PathVariable Long id, @RequestBody List<UnitNodeDTO> nodes) {
        Organization org = orgService.getOrganization(id);
        AdministrativeUnit rootUnit = (AdministrativeUnit) administrativeUnitRepository.findAll().get(0);

        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner());
        if(Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")){
            throw new ApiException("Units creation request rejected by the hierarchy");
        }
        saveUnits(nodes, org, rootUnit);

        return true;

    }

    public void saveUnits(List<UnitNodeDTO> units, Organization org, AdministrativeUnit root) {
        Queue<UnitNodeDTO> queue = new LinkedList<>();
        // Find root nodes (with parent null) and add them to the queue
        for (UnitNodeDTO unit : units) {
            if (unit.getParent() == null) {
                queue.add(unit);
            }
        }

        // Process nodes in the queue iteratively
        while (!queue.isEmpty()) {
            UnitNodeDTO currentNode = queue.poll();

            // Simulate saving the current node (replace with your actual save logic)
            System.out.println("Saving node: " + currentNode.getName());

            UnitNode node = modelMapper.map(currentNode, UnitNode.class);
            node.setOrganization(org);
            boolean isOperational = isOperational(currentNode, units);

            AdministrativeUnit parent = administrativeUnitRepository.findByKey(node.getParent());


            if (isOperational) {
                OperationalUnit unit = new OperationalUnit();
                unit.setName(node.getName());
                unit.setDescription(node.getDescription());
                unit.setKey(node.getKey());
                unit.setOrganization(org);
                unit = operationalUnitRepository.save(unit);
                PlaceUnder under = new PlaceUnder();
                under.setOrganization(org);
                under.setSubordinate(unit);
                under.setSuperior(parent);
                underService.save(under);
            } else if (node.getParent() != null){
                AdministrativeUnit unit = new AdministrativeUnit();
                unit.setName(node.getName());
                unit.setDescription(node.getDescription());
                unit.setKey(node.getKey());
                unit.setOrganization(org);
                unit = administrativeUnitRepository.save(unit);
                Subordinate subordinate = new Subordinate();
                subordinate.setOrganization(org);
                subordinate.setSubordinate(unit);
                subordinate.setSuperior(parent);
                subService.save(subordinate);
            }
            else {
                root.setName(node.getName());
                root.setDescription(node.getDescription());
                root.setKey(node.getKey());
                root.setOrganization(org);
                root.setId(root.getId());
                root = administrativeUnitRepository.save(root);
            }

            unitNodeRepository.save(node);
            // Add child nodes to the queue
            for (UnitNodeDTO unit : units) {
                if (unit.getParent() != null && unit.getParent().equals(currentNode.getKey())) {
                    queue.add(unit);
                }
            }
        }
    }

    public boolean isOperational(UnitNodeDTO node, List<UnitNodeDTO> units) {
        return units.stream().noneMatch(unit -> node.getKey().equals(unit.getParent()));
    }

    private void traverse(OrgTree child) {
        for (OrgTree t : child.getChildren()) {
            System.out.println(child.getData().getName());
            System.out.println(t.getData().getName());
            traverse(t);
        }
        System.out.println("\n");

    }

    private ResponseEntity<AppResponse> triggerApproval(Organization organization, Employee owner) {
        User approverUser = userService.getUserByEmployee(owner).get();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AccessRequest.AccessRequestBuilder builder = AccessRequest.builder().userId(principal.getUsername())
                .timeout(15)
                .priority(1)
                .requiredApproval(true)
                .approvalLevel(1)
                .operationId("CREATE")
                .resourceId("UNITS")
                .unit("ADMIN")
                .org(organization.getName())
                .status("ALLOWED")
                .approvalType(ApprovalType.SEQUENTIAL)
                .approvers(Collections.singletonList(
                        new Approver(approverUser.getUsername(), approverUser.getEmail(), null)));

        return approvalService.handleApproval(
                builder);
    }

}
