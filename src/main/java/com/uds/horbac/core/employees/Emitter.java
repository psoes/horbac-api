package com.uds.horbac.core.employees;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
public class Emitter extends WorkEmployee
{

}

