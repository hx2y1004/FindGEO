package com.findgeo.dto;

import org.modelmapper.ModelMapper;

import com.findgeo.entity.Clipping;

import groovy.util.logging.Slf4j;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectPingDto {
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
	private String trafMark;
	private String fdMark;
	private String svMark;
	private String retaMark;
	private String arMark;
	
	public Clipping toClip() {
		return Clipping.builder()
				.email(email)
				.areaname(areaname)
				.congest(congest)
				.rate0(rate0)
				.rate10(rate10)
				.rate20(rate20)
				.rate30(rate30)
				.rate40(rate40)
				.rate50(rate50)
				.rate60(rate60)
				.rate70(rate70)
				.male(female)
				.female(female)
				.resnt(resnt)
				.nonresnt(nonresnt)
				.selectlat(selectlat)
				.selectlng(selectlng)
//				.trafMark(trafMark)
//				.fdMark(fdMark)
//				.svMark(svMark)
//				.retaMark(retaMark)
//				.arMark(arMark)
				.build();
	}
	
	
	
}
