package com.findgeo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.findgeo.dto.ArDto;
import com.findgeo.dto.FdDto;
import com.findgeo.dto.MyClipDto;
import com.findgeo.dto.RetaDto;
import com.findgeo.dto.SelectPingDto;
import com.findgeo.dto.SvDto;
import com.findgeo.dto.TrafDto;
import com.findgeo.entity.Armark;
import com.findgeo.entity.Clipping;
import com.findgeo.entity.Fdmark;
import com.findgeo.entity.Retamark;
import com.findgeo.entity.Svmark;
import com.findgeo.entity.Trafmark;
import com.findgeo.repository.ArRepository;
import com.findgeo.repository.ClippingRepository;
import com.findgeo.repository.ClippingRepositoryImpl;
import com.findgeo.repository.FdRepository;
import com.findgeo.repository.RetaRepository;
import com.findgeo.repository.SvRepository;
import com.findgeo.repository.TrafRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClippingService {

	private final ClippingRepository clippingRepository;
	private final TrafRepository trafRepository;
	private final FdRepository fdRepository;
	private final SvRepository svRepository;
	private final RetaRepository retaRepository;
	private final ArRepository arRepository;
	private final ClippingRepositoryImpl clippingRepositoryImpl; 
	
	public Long savePingInfo(SelectPingDto selectPingDto) {
		return clippingRepository.save(selectPingDto.toClip()).getClipid();
	}
	
	public Long saveTraf(TrafDto trafdto,Long id) {
		Clipping clipping = clippingRepository.findByClipid(id);
		Trafmark trafmark = Trafmark.builder()
				.clipping(clipping)
				.traflat(trafdto.getTraflat())
				.traflng(trafdto.getTraflng())
				.build();
		
		return trafRepository.save(trafmark).getTrafmarkid();
	}
	
	public Long savefd(FdDto fddto, Long id) {
		Clipping clipping = clippingRepository.findByClipid(id);
		Fdmark fdmark = Fdmark.builder()
				.clipping(clipping)
				.fdlat(fddto.getFdlat())
				.fdlng(fddto.getFdlng())
				.build();
		
		return fdRepository.save(fdmark).getFdmarkid();
	}
	
	public Long savesv(SvDto svdto, Long id) {
		Clipping clipping = clippingRepository.findByClipid(id);
		Svmark svmark = Svmark.builder()
				.clipping(clipping)
				.svlat(svdto.getSvlat())
				.svlng(svdto.getSvlng())
				.build();
		
		return svRepository.save(svmark).getSvmarkid();
	}
	
	public Long savereta(RetaDto retadto, Long id) {
		Clipping clipping = clippingRepository.findByClipid(id);
		Retamark retamark = Retamark.builder()
				.clipping(clipping)
				.retalat(retadto.getRetalat())
				.retalng(retadto.getRetalng())
				.build();
		
		return retaRepository.save(retamark).getRetamarkid();
	}
	
	public Long savear(ArDto ardto, Long id) {
		Clipping clipping = clippingRepository.findByClipid(id);
		Armark armark = Armark.builder()
				.clipping(clipping)
				.arlat(ardto.getArlat())
				.arlng(ardto.getArlng())
				.build();
		
		return arRepository.save(armark).getArmarkid();
	}
	
	public List<Clipping> selMyClip(Long clipid) {
//		List<MyClipDto> myClipList = clippingRepositoryImpl.findByEmailQuerydsl(clipid);
		List<Clipping> myClipList = clippingRepository.findByClipidList(clipid);
		return myClipList;
	}
	
	public List<Clipping> selClipList(String email){
		List<Clipping> clipList = clippingRepository.findByEmail(email);
		return clipList;
	}
}
