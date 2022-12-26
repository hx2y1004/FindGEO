package com.findgeo.dto;

import com.findgeo.entity.Clipping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetaDto {
	private Long retamarkid;
	private String retalat;
	private String retalng;
	private Clipping clipping;
}
