package com.findgeo.repository;

import java.util.List;

import javax.sound.sampled.Clip;

import org.springframework.stereotype.Repository;

import com.findgeo.dto.MyClipDto;
import com.findgeo.entity.Clipping;
import com.findgeo.entity.QArmark;
import com.findgeo.entity.QClipping;
import com.findgeo.entity.QFdmark;
import com.findgeo.entity.QRetamark;
import com.findgeo.entity.QSvmark;
import com.findgeo.entity.QTrafmark;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClippingRepositoryImpl implements ClippingRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<MyClipDto> findByEmailQuerydsl(Long clipid) {

		QClipping clipping = QClipping.clipping;

		QArmark armark = QArmark.armark;

		QFdmark fdmark = QFdmark.fdmark;

		QRetamark retamark = QRetamark.retamark;

		QSvmark svmark = QSvmark.svmark;

		QTrafmark trafmark = QTrafmark.trafmark;

		List<MyClipDto> result = queryFactory
				.select(Projections.constructor(MyClipDto.class, clipping.clipid, clipping.areaname, clipping.congest,
						clipping.email, clipping.male, clipping.female, clipping.resnt, clipping.nonresnt,
						clipping.rate0, clipping.rate10, clipping.rate20, clipping.rate30, clipping.rate40,
						clipping.rate50, clipping.rate60, clipping.rate70, clipping.selectlat, clipping.selectlng,
						clipping.areagrade, fdmark.fdmarkid, fdmark.fdlat, fdmark.fdlng, armark.armarkid, armark.arlat,
						armark.arlng, svmark.svmarkid, svmark.svlat, svmark.svlng, retamark.retamarkid,
						retamark.retalat, retamark.retalng, trafmark.trafmarkid, trafmark.traflat, trafmark.traflng))
				.from(clipping).leftJoin(trafmark).on(clipping.clipid.eq(trafmark.clipping.clipid)).leftJoin(fdmark)
				.on(clipping.clipid.eq(fdmark.clipping.clipid)).leftJoin(retamark)
				.on(clipping.clipid.eq(retamark.clipping.clipid)).leftJoin(svmark)
				.on(clipping.clipid.eq(svmark.clipping.clipid)).leftJoin(armark)
				.on(clipping.clipid.eq(armark.clipping.clipid)).where(clipping.clipid.eq(clipid)).fetch();

		return result;
	}

}
