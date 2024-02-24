package com.uds.horbac.core.annotations;

import com.uds.horbac.core.dao.employees.AppointsRepository;
import com.uds.horbac.core.dao.employees.EmploysRepository;
import com.uds.horbac.core.dao.permissions.OperationalPermissionRepository;
import com.uds.horbac.core.dao.users.UserRepository;
import com.uds.horbac.core.entities.permissions.OperationalPermission;
import com.uds.horbac.core.entities.units.OrgUnit;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.security.ActivityType;
import com.uds.horbac.core.security.ViewType;
import com.uds.horbac.core.service.employees.AppointsService;
import com.uds.horbac.core.service.employees.EmploysService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class IsAllowedAspect {

    @Autowired
    OperationalPermissionRepository operationalPermissionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppointsRepository appointsRepository;

    @Autowired
    EmploysRepository employsRepository;

    @Around("@annotation(isAllowed)")
    public Object doCheck(ProceedingJoinPoint joinPoint, IsAllowed isAllowed) throws Throwable {
        // Check activity and view permissions
        ViewType view = isAllowed.view();
        ActivityType activityType = isAllowed.activity();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        String username;
        if (principal instanceof User) {
            user = ((User)principal);
        } else {
            username = principal.toString();
        }
        OrgUnit unit = null;
        if(user != null) {
            unit = appointsRepository.findFirstByEmployee(user.getEmployee()).getAdminUnit();
            if(unit == null) {
                unit = employsRepository.findFirstByEmployee(user.getEmployee()).getOperationalUnit();
            }
        }
        OperationalPermission permission = operationalPermissionRepository.findFirstByActivityIdAndVueIdAndUnitId(activityType.getCode(), view.getCode(), unit.getId());
        if (permission != null) {
            // Allow method execution
            return joinPoint.proceed();
        } else {
            // Throw an exception or handle unauthorized access
            throw new AccessDeniedException("Insufficient permissions");
        }
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }
}
