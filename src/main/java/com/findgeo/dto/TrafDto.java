package com.findgeo.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.findgeo.entity.Clipping;
import com.findgeo.entity.Trafmark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrafDto {
	private Long trafmarkid;
	private String traflat;
	private String traflng;
	private Clipping clipping;
}
