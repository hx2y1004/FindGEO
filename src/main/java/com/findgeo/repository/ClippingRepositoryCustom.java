package com.findgeo.repository;

import java.util.List;

import com.findgeo.dto.MyClipDto;
import com.findgeo.entity.Clipping;
import com.querydsl.core.Tuple;

public interface ClippingRepositoryCustom {
	List<MyClipDto> findByEmailQuerydsl(Long clipid);
}
