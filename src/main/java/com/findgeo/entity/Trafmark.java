package com.findgeo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;

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
	
	@ManyToOne
	@JoinColumn(name="clipid")
	private Clipping clipping;
}
