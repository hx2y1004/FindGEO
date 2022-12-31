package com.findgeo.entity;

import java.util.List;

import javax.persistence.Column;
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
public class Trafmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trafmarkid;

	private String traflat;
	private String traflng;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clipid")
	private Clipping clipping;

	@Builder
	public Trafmark(String traflat, String traflng, Clipping clipping) {
		this.traflat = traflat;
		this.traflng = traflng;
		this.clipping = clipping;
	}
}
