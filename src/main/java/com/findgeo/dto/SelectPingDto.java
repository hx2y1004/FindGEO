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
	private float rate0;
	private float rate10;
	private float rate20;
	private float rate30;
	private float rate40;
	private float rate50;
	private float rate60;
	private float rate70;
	private float female;
	private float male;
	private float resnt;
	private float nonresnt;
	private String selectlat;
	private String selectlng;
	private String areagrade;
	private String category;
	private String seloption;
	private String areacate;
	private String areaoption;
	private String trafcate;
	private String trafoption;
	
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
				.category(category)
				.seloption(seloption)
				.areacate(areacate)
				.areaoption(areaoption)
				.trafcate(trafcate)
				.trafoption(trafoption)
				.build();
	}
	
	
	
}
