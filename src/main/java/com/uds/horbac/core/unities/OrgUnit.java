package com.uds.horbac.core.unities;

import java.net.URL;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.Location;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class OrgUnit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
	
	@OneToOne
    private Location location;

	private URL url;

}
