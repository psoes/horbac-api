package com.uds.horbac.core.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Approver {
    private String username;
    private String email;
    private Boolean canApprove;
}
