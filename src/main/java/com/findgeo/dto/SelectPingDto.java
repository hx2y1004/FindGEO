package com.findgeo.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.findgeo.entity.Armark;
import com.findgeo.entity.Clipping;
import com.findgeo.entity.Fdmark;
import com.findgeo.entity.Retamark;
import com.findgeo.entity.Svmark;
import com.findgeo.entity.Trafmark;

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
	private String areagrade;
	
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
				.male(male)
				.female(female)
				.resnt(resnt)
				.nonresnt(nonresnt)
				.selectlat(selectlat)
				.selectlng(selectlng)
				.areagrade(areagrade)
				.build();
	}
	
	
	
}
