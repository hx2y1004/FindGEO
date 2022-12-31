package com.findgeo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamicInsert
@Entity
@Table(name = "clipping")
@Getter
@Setter
@NoArgsConstructor
public class Clipping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clipid;

	@Column(nullable = false)
	private String areaname;

	private String email;

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

//	@OneToMany(mappedBy="clipping", cascade = CascadeType.ALL)
//	private List<Trafmark> trafmark;
//
//	@OneToMany(mappedBy="clipping", cascade = CascadeType.ALL)
//	private List<Fdmark> fdmark;
//	
//	@OneToMany(mappedBy="clipping", cascade = CascadeType.ALL)
//	private List<Svmark> svmark;
//
//	@OneToMany(mappedBy="clipping", cascade = CascadeType.ALL)
//	private List<Retamark> retamark;
//	
//	@OneToMany(mappedBy="clipping", cascade = CascadeType.ALL)
//	private List<Armark> armark;

	@Builder
	public Clipping(String areaname, String email, String congest, float rate0, float rate10, float rate20,
			float rate30, float rate40, float rate50, float rate60, float rate70, float female, float male, float resnt,
			float nonresnt, String selectlat, String selectlng, String areagrade, String category, String seloption,
			String areacate, String areaoption, String trafcate, String trafoption) {

		this.email = email;
		this.areaname = areaname;
		this.congest = congest;
		this.rate0 = rate0;
		this.rate10 = rate10;
		this.rate20 = rate20;
		this.rate30 = rate30;
		this.rate40 = rate40;
		this.rate50 = rate50;
		this.rate60 = rate60;
		this.rate70 = rate70;
		this.male = male;
		this.female = female;
		this.resnt = resnt;
		this.nonresnt = nonresnt;
		this.selectlat = selectlat;
		this.selectlng = selectlng;
		this.areagrade = areagrade;
		this.category = category;
		this.seloption = seloption;
		this.areacate = areacate;
		this.areaoption = areaoption;
		this.trafcate = trafcate;
		this.trafoption = trafoption;
	}

}
