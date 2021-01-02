package com.uds.horbac.core.dto.employees;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class ApproverDTO extends EmployeeDTO
{
    private Long id;
}

