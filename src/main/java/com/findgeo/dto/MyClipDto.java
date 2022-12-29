package com.findgeo.dto;

import com.findgeo.entity.Clipping;
import com.querydsl.core.annotations.QueryProjection;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyClipDto {
	private Long clipid;
	private String email;
	private String areaname;
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
	private int nonresnt;
	private String selectlat;
	private String selectlng;
	private String areagrade;
//	private Long armarkid;
//	private String arlat;
//	private String arlng;
//	private Long fdmarkid;
//	private String fdlat;
//	private String fdlng;
//	private Long retamarkid;
//	private String retalat;
//	private String retalng;
//	private Long svmarkid;
//	private String svlat;
//	private String svlng;
//	private Long trafmarkid;
//	private String traflat;
//	private String traflng;
//	
//	@QueryProjection
//	public MyClipDto(Long clipid, String email, String areaname, String congest, int rate0, int rate10, int rate20, int rate30,
//			         int rate40, int rate50, int rate60, int rate70, int male, int female, int resnt, int nonresnt, 
//			         String selectlat, String selectlng , String areagrade, Long armarkid, String arlat, String arlng, 
//			         Long fdmarkid, String fdlat, String fdlng, Long retamarkid, String retalat, String retalng, 
//			         Long svmarkid, String svlat, String svlng, Long trafmarkid, String traflat, String traflng) {
//		this.clipid = clipid;
//		this.email = email;
//		this.congest = congest;
//		this.rate0 = rate0;
//		this.rate10 = rate10;
//		this.rate20 = rate20;
//		this.rate30 = rate30;
//		this.rate40 = rate40;
//		this.rate50 = rate50;
//		this.rate60 = rate60;
//		this.rate70 = rate70;
//		this.male = male;
//		this.female = female;
//		this.resnt = resnt;
//		this.nonresnt = nonresnt;
//		this.selectlat = selectlat;
//		this.selectlng = selectlng;
//		this.areagrade = areagrade;
//		this.armarkid = armarkid;
//		this.arlat = arlat;
//		this.arlng = arlng;
//		this.fdmarkid = fdmarkid;
//		this.fdlat = fdlat;
//		this.fdlng = fdlng;
//		this.retamarkid = retamarkid;
//		this.retalat = retalat;
//		this.retalng = retalng;
//		this.svmarkid = svmarkid;
//		this.svlat = svlat;
//		this.svlng = svlng;
//		this.trafmarkid = trafmarkid;
//		this.traflat = traflat;
//		this.traflng = traflng;
//		
//	}
			
	
}
