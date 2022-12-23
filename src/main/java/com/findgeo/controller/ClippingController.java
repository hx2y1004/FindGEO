package com.findgeo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.findgeo.dto.SelectPingDto;
import com.findgeo.service.ClippingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ClippingController {

	private final ClippingService clippingService;
	
	@PostMapping("/clipping/{email}")
	public Long clipsave(@RequestBody SelectPingDto pingdto) {
		return clippingService.savePingInfo(pingdto);
	}
	
}
