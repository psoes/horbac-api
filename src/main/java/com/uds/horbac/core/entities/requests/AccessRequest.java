package com.uds.horbac.core.entities.requests;

import com.uds.horbac.core.entities.users.Approver;
import com.uds.horbac.core.entities.users.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessRequest {
    public enum ClientType {
        DESKTOP, MOBILE, TABLET
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Date requestDate;
    private String userId;
    private String resourceId;
    private String operationId;
    private String ipAddress;
    private String osName;
    private String osVersion;
    private String clientType;
    private String clientName;
    private String status;
    private String locale;
    private String userAgent;
    private String agentVersion;
    private String unit;
    private String org;
    private Boolean requiredApproval;
    private Integer approvalLevel;
    private Integer priority;
    private Integer timeout;
    private transient List<Approver> approvers;
}
