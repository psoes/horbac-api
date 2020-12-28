package com.uds.horbac.core.emp_ownershipInfo.dto;

import com.uds.horbac.core.contexts.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountProviderDTO {

    private Long id;

    private String name;

    private String address;

    private Location location;
  
}
