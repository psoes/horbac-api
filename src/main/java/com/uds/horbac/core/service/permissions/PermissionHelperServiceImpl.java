package com.uds.horbac.core.service.permissions;

import com.uds.horbac.core.dao.activities.ConsiderRepository;
import com.uds.horbac.core.dao.contexts.DefineRepository;
import com.uds.horbac.core.dao.employees.AppointsRepository;
import com.uds.horbac.core.dao.employees.EmploysRepository;
import com.uds.horbac.core.dao.permissions.AdministrativePermissionRepository;
import com.uds.horbac.core.dao.permissions.OperationalPermissionRepository;
import com.uds.horbac.core.dao.resources.UsesRepository;
import com.uds.horbac.core.dao.units.PlaceUnderRepository;
import com.uds.horbac.core.dao.users.UserRepository;
import com.uds.horbac.core.entities.activities.Activity;
import com.uds.horbac.core.entities.activities.Consider;
import com.uds.horbac.core.entities.contexts.Context;
import com.uds.horbac.core.entities.contexts.Define;
import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.AdministrativePermission;
import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.permissions.CanTreat;
import com.uds.horbac.core.entities.permissions.OperationalPermission;
import com.uds.horbac.core.entities.requests.AccessRequest;
import com.uds.horbac.core.entities.requests.AppResponse;
import com.uds.horbac.core.entities.requests.HelperReponse;
import com.uds.horbac.core.entities.resources.Uses;
import com.uds.horbac.core.entities.resources.Vue;
import com.uds.horbac.core.entities.units.*;
import com.uds.horbac.core.entities.users.Approver;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.service.units.OrgTreeService;
import com.uds.horbac.integration.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionHelperServiceImpl implements PermissionHelperService {


    @Autowired
    private AdministrativePermissionRepository adminPermissionRepository;

    @Autowired
    private OperationalPermissionRepository opPermissionRepository;

    @Autowired
    private EmploysRepository employsRepository;

    @Autowired
    private AppointsRepository appointsRepository;


    @Autowired
    private UsesRepository usesRepository;

    @Autowired
    private ConsiderRepository considerRepository;


    @Autowired
    private DefineRepository defineRepository;

    @Autowired
    private PlaceUnderRepository placeUnderRepository;

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    OrgTreeService orgTreeService;

    @Autowired
    UserRepository userRepository;

    @Override
    public HelperReponse canSuggest(Organization org, CanSuggest cans) {

        List<OperationalPermission> ops = opPermissionRepository.findByEmployeeAndActionAnResource(
                cans.getEmitter().getId(), cans.getAction().getId(), cans.getResource().getId()
        );

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        if (ops == null || ops.isEmpty()) {
            return HelperReponse.builder().decision("DENIED").build();
        }
        List<OrgUnit> trees = null;
        List<User> approvers = null;
        if (ops.get(0).getApprovalLevel() != null && ops.get(0).getApprovalLevel() != 0) {
            trees = OrgTree.getApprovers(orgTreeService.getOrgTree(org), ops.get(0).getUnit(),
                    ops.get(0).getApprovalLevel() != null ? ops.get(0).getApprovalLevel() : 0
            );
            approvers = userRepository.findUsersByAdminUnitIds(trees.stream().map(OrgUnit::getId).collect(Collectors.toList()));
        }

        if (trees == null) {
            return HelperReponse.builder().decision("ALLOWED").build();
        }

        String operation = String.format("User <%s> asks to apply <%s> operation on resource <%s>", cans.getEmitter().getFirstName(), cans.getAction().getName(), cans.getResource().getName());
        AccessRequest.AccessRequestBuilder builder = AccessRequest.builder().userId(username)
                .timeout(ops.get(0).getTimeout() != null ? ops.get(0).getTimeout() : 10)
                .priority(ops.get(0).getPriority() != null ? ops.get(0).getPriority() : 3)
                .requiredApproval(ops.get(0).getRequiredApproval() != null ? ops.get(0).getRequiredApproval() : false)
                .approvalLevel(ops.get(0).getApprovalLevel() != null ? ops.get(0).getApprovalLevel() : 0)
                .operationId(operation)
                .resourceId(cans.getResource().getName())
                .unit(ops.get(0).getUnit().getName())
                .org(org.getName())
                .status("ALLOWED")
                .approvalType(ops.get(0).getApprovalType())
                .approvers(approvers!= null ? approvers.stream().map(
                        item -> new Approver(item.getUsername(), item.getEmail(), null)
                ).collect(Collectors.toList()) :  null);

        ResponseEntity<AppResponse> respo =  approvalService.handleApproval(
                builder);

       HelperReponse lastResponse = new HelperReponse(
               respo.getBody().getDuration(),
               respo.getBody().getDecision(),
               ops
       );
        return lastResponse;
    }


    @Override
    public List<AdministrativePermission> canTreat(Organization org, CanTreat cant) {

        Appoints ap = appointsRepository.findAllByOrganizationAndEmployee(org, cant.getApprover());

        AdministrativeUnit au = ap != null ? ap.getAdminUnit() : null;

        Employs emp = employsRepository.findAllByOrganizationAndEmployee(org, cant.getEmitter());
        OperationalUnit ou = emp != null ? emp.getOperationalUnit() : null;
        Consider con = considerRepository.findAllByOrganizationAndAction(org, cant.getAction());
        Activity a = con != null ? con.getActivity() : null;
        Uses uses = usesRepository.findAllByOrganizationAndResource(org, cant.getResource());
        Vue v = uses != null ? uses.getVue() : null;
        Define def = defineRepository.findAllByOrganizationAndEmployeeAndActionAndResource(org, cant.getApprover(), cant.getAction(), cant.getResource());
        Context c = def != null ? def.getContext() : null;

        PlaceUnder pl = placeUnderRepository.findAllByOrganizationAndSuperiorAndSubordinate(org, au, ou);
        OperationalUnit ou1 = pl != null ? pl.getSubordinate() : null;
        Specification<AdministrativePermission> secSpec = new Specification<AdministrativePermission>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<AdministrativePermission> root, CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (ou1 != null)
                    predicates.add(criteriaBuilder.equal(root.get("operationalUnit").get("id"), ou.getId()));
                if (au != null)
                    predicates.add(criteriaBuilder.equal(root.get("administrativeUnit").get("id"), au.getId()));
                if (a != null) predicates.add(criteriaBuilder.equal(root.get("activity").get("id"), a.getId()));
                if (v != null) predicates.add(criteriaBuilder.equal(root.get("vue").get("id"), v.getId()));
                if (c != null) predicates.add(criteriaBuilder.equal(root.get("context").get("id"), c.getId()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        if (ou1 == null) return null;
        if (au == null) return null;
        if (a == null) return null;
        if (v == null) return null;
        List<AdministrativePermission> ops = adminPermissionRepository.findAll(secSpec);
        return ops;

    }


}
