package com.findgeo.dto;

import com.findgeo.entity.Clipping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArDto {
	private Long armarkid;
	private String arlat;
	private String arlng;
	private Clipping clipping;
}
