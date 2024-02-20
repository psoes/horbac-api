package com.uds.horbac.core.dto.units;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UnitNodeDTO {
    private Long id;
    private String key;
    private String name;
    private String description;
    private String parent;
    private Long orgId;
}
