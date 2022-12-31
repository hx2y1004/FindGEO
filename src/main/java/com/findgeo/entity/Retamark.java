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
public class Retamark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long retamarkid;

	private String retalat;
	private String retalng;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clipid")
	private Clipping clipping;

	@Builder
	public Retamark(String retalat, String retalng, Clipping clipping) {
		this.retalat = retalat;
		this.retalng = retalng;
		this.clipping = clipping;
	}
}
