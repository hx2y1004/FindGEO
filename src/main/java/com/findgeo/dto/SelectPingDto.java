package com.findgeo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectPingDto {
	private Long clipid;
	private String areaName;
	private String congest;
	private int rate0;
	private int rate10;
	private int rate20;
	private int rate30;
	private int rate40;
	private int rate50;
	private int rate60;
	private int rate70;
	private int female;
	private int male;
	private int resnt;
	private int nonResnt;
	private String selectlat;
	private String selectlng;
	private String areaData;
}
