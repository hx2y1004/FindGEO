package com.findgeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@Entity
@Table(name = "clipping")
@Getter
@NoArgsConstructor
public class Clipping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clipid;
	
	@Column(nullable = false)
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
//	private String traflat;
//	private String traflng;
//	private String fdlat;
//	private String fdlng;
//	private String svlat;
//	private String svlng;
//	private String retalat;
//	private String retalng;
//	private String arlat;
//	private String arlng;
	
	
}
