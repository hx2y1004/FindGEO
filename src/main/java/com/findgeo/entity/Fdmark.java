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
public class Fdmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fdmarkid;

	private String fdlat;
	private String fdlng;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clipid")
	private Clipping clipping;

	@Builder
	public Fdmark(String fdlat, String fdlng, Clipping clipping) {
		this.fdlat = fdlat;
		this.fdlng = fdlng;
		this.clipping = clipping;
	}
}
