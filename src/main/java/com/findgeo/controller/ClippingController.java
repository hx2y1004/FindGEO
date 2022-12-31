package com.findgeo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.findgeo.dto.ArDto;
import com.findgeo.dto.FdDto;
import com.findgeo.dto.MyClipDto;
import com.findgeo.dto.RetaDto;
import com.findgeo.dto.SelectPingDto;
import com.findgeo.dto.SvDto;
import com.findgeo.dto.TrafDto;
import com.findgeo.entity.Clipping;
import com.findgeo.entity.Trafmark;
import com.findgeo.service.ClippingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ClippingController {

	private final ClippingService clippingService;
	Long clipid;

	@PostMapping("/clipping/{email}")
	public Long clipsave(@RequestBody SelectPingDto pingdto) {
		clipid = clippingService.savePingInfo(pingdto);
		return clipid;
	}

	@PostMapping("/clipping/traf")
	public Long clipsavetraf(@RequestBody TrafDto trafdto) {
		return clippingService.saveTraf(trafdto, clipid);
	}

	@PostMapping("/clipping/fd")
	public Long clipsavefd(@RequestBody FdDto fddto) {
		return clippingService.savefd(fddto, clipid);
	}

	@PostMapping("/clipping/sv")
	public Long clipsavesv(@RequestBody SvDto svdto) {
		return clippingService.savesv(svdto, clipid);
	}

	@PostMapping("/clipping/reta")
	public Long clipsavereta(@RequestBody RetaDto retadto) {
		return clippingService.savereta(retadto, clipid);
	}

	@PostMapping("/clipping/ar")
	public Long clipsavear(@RequestBody ArDto ardto) {
		return clippingService.savear(ardto, clipid);
	}
}
