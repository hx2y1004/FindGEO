package com.findgeo.dto;

import com.findgeo.entity.Clipping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SvDto {
	private Long svmarkid;
	private String svlat;
	private String svlng;
	private Clipping clipping;
}
