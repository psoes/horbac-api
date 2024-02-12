package com.uds.horbac.core.entities.requests;

import com.uds.horbac.core.entities.permissions.OperationalPermission;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelperReponse {
    private  long duration;
    private String decision;
    private List<OperationalPermission> permissions;
}
