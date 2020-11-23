package com.uds.horbac.core.activities.dto;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {
	
	private Long id;
	
	@ApiModelProperty(name="The label of activity", example="view")
	@NotNull
	private String label;
}
