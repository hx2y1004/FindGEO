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
	
	@Column( nullable = false)
	private String areaname;
	
	@Column(unique = true)
	private String email;
	
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
	
	@OneToMany(mappedBy="clipping", cascade = CascadeType.REMOVE)
	private List<Trafmark> trafmark = new ArrayList<>();

	@OneToMany(mappedBy="clipping", cascade = CascadeType.REMOVE)
	private List<Fdmark> fdmark = new ArrayList<>();
	
	@OneToMany(mappedBy="clipping", cascade = CascadeType.REMOVE)
	private List<Svmark> svmark = new ArrayList<>();

	@OneToMany(mappedBy="clipping", cascade = CascadeType.REMOVE)
	private List<Retamark> retamark = new ArrayList<>();
	
	@OneToMany(mappedBy="clipping", cascade = CascadeType.REMOVE)
	private List<Armark> armark = new ArrayList<>();

	@Builder
	public Clipping(String areaname,String email ,String congest, int rate0, int rate10, int rate20, 
				int rate30, int rate40, int rate50, int rate60, int rate70, 
				int female, int male, int resnt, int nonresnt, String selectlat, String selectlng,
				List<Trafmark> trafmark, List<Fdmark> fdmark, List<Svmark> svmark ,
				List<Retamark> retamark, List<Armark> armark
			) {

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
		this.trafmark = trafmark;
		this.fdmark = fdmark;
		this.svmark = svmark;
		this.retamark = retamark;
		this.armark = armark;
	}
	
	
}
