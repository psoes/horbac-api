package com.uds.horbac.core.emp_ownershipInfo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiensImmobiliersDTO {

    public Long id;

    public String name;

    public String location;

    public Date dateObtention;
}
