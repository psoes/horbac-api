package com.uds.horbac.core.entities.units;

import com.uds.horbac.core.entities.organizations.Organization;
import io.lettuce.core.GeoArgs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UnitNode {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String key;
    private String name;
    private String description;
    private String parent;

    @ManyToOne
    private Organization organization;

}