package com.findgeo.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.findgeo.dto.SelectPingDto;
import com.findgeo.entity.Clipping;
import com.findgeo.repository.ClippingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClippingService {

	private final ClippingRepository clippingRepository;
	
	public Long savePingInfo(SelectPingDto selectPingDto) {
		return clippingRepository.save(selectPingDto.toClip()).getClipid();
	}
	
}
