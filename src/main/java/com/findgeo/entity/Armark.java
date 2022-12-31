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
public class Armark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long armarkid;

	private String arlat;
	private String arlng;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clipid")
	private Clipping clipping;

	@Builder
	public Armark(String arlat, String arlng, Clipping clipping) {
		this.arlat = arlat;
		this.arlng = arlng;
		this.clipping = clipping;
	}
}
