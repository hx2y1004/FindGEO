package com.findgeo.dto;

import com.findgeo.entity.Clipping;
import com.findgeo.entity.Fdmark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FdDto {
	private Long fdmarkid;
	private String fdlat;
	private String fdlng;
	private Clipping clipping;
}
