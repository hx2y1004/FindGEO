package com.findgeo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.AreaDataDto;
import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;
import com.nimbusds.openid.connect.sdk.claims.UserInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final HttpSession httpSession;
	private final MemberRepository memberRepository;
	
	
  	// 목욕탕,숙박,쇼핑,관공서,주요시설물,은행,ATM,편의점,미용실,이발소,대형마트,화장실,공원,커피,음식,레저,호텔,마트,
	// 식음료, TV맛집, 카페, 한식, 중식, 일식, 패밀리레스토랑, 전문음식점, 
	// 피자,치킨, 디저트, 제과점, 베스킨라빈스, 하겐다즈, 나뚜루, 콜드스톤, 패스트푸드,
	// 교통, 버스, 버스정류장, 지하철, 주유소, 충전소, 주차장, 정비소, EV충전소, EV/가스충전소
	// 병원, 약국, 내과, 소아과, 외과, 치과, 안과, 의원, 보건소, 한의원
	// 놀거리, 영화관, 노래방, PC방, 공연장, 문화시설, 스크린골프장
	
	@GetMapping("/")
	public String index(Model model,Principal principal) { 
		SessionMember member =(SessionMember)httpSession.getAttribute("user");

		String[] foodData = {
				"선택","한식","중식","일식","카페","패밀리레스토랑","전문음식점","피자","치킨","디저트","제과점","패스트푸드"
		};
		String[] serviceData = {
				"선택","목욕탕","미용실","이발소","호텔","병원","약국","내과","소아과","외과","치과","안과","의원","보건소","한의원","영화관","노래방","PC방",
				"스크린골프장","은행","정비소"
		};
		String[] retailData = {
				"선택","쇼핑","편의점","대형마트","마트","식음료"
		};
		String[] trafficData = {
				"선택","버스정류장","지하철","주유소","충전소","주차장","EV충전소","EV/가스충전소"
		};
		String[] areaData = {
				"선택","관공서","주요시설물","ATM","화장실","공원","공연장","문화시설"
		};
		List<AreaDataDto> serviceDataList = new ArrayList<>();
		for(int i = 0; i < serviceData.length; i++) {
			AreaDataDto aData = new AreaDataDto();
			aData.setIndex(i);
			aData.setCategory(serviceData[i]);
			serviceDataList.add(aData);
		}
		
		List<AreaDataDto> foodDataList = new ArrayList<>();
		for(int i = 0; i < foodData.length; i++) {
			AreaDataDto aData = new AreaDataDto();
			aData.setIndex(i);
			aData.setCategory(foodData[i]);
			foodDataList.add(aData);
		}
		
		List<AreaDataDto> retailDataList = new ArrayList<>();
		for(int i = 0; i < retailData.length; i++) {
			AreaDataDto aData = new AreaDataDto();
			aData.setIndex(i);
			aData.setCategory(retailData[i]);
			retailDataList.add(aData);
		}
		
		List<AreaDataDto> trafficDataList = new ArrayList<>();
		for(int i = 0; i < trafficData.length; i++) {
			AreaDataDto aData = new AreaDataDto();
			aData.setIndex(i);
			aData.setCategory(trafficData[i]);
			trafficDataList.add(aData);
		}
		
		List<AreaDataDto> areaDataList = new ArrayList<>();
		for(int i = 0; i < areaData.length; i++) {
			AreaDataDto aData = new AreaDataDto();
			aData.setIndex(i);
			aData.setCategory(areaData[i]);
			areaDataList.add(aData);
		}

		model.addAttribute("foodDataList",foodDataList);
		model.addAttribute("serviceDataList",serviceDataList);
		model.addAttribute("retailDataList",retailDataList);
		model.addAttribute("trafficDataList",trafficDataList);
		model.addAttribute("areaDataList",areaDataList);
		if(principal == null && member == null) {}
		else if(principal!= null && member == null) {
			Member userName = memberRepository.findByEmail(principal.getName());
			String name = userName.getNickname();
			String email = userName.getEmail();
			model.addAttribute("email",email);
			model.addAttribute("name",name);
		}else if(principal != null && member != null ) {
			model.addAttribute("email",member.getEmail());
			model.addAttribute("name",member.getNickname());
		}
	
		return "index";
	}
	
}

