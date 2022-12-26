package com.findgeo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamicInsert
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Svmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long svmarkid;
	
	private String svlat;
	private String svlng;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clipid")
	private Clipping clipping;
	
	@Builder
	public Svmark(String svlat, String svlng, Clipping clipping) {
		this.svlat = svlat;
		this.svlng = svlng;
		this.clipping = clipping;
	}
	
}
