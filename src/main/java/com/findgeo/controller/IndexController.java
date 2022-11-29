package com.findgeo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.findgeo.config.dto.SessionMember;
import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;
import com.nimbusds.openid.connect.sdk.claims.UserInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final HttpSession httpSession;
	private final MemberRepository memberRepository;

	@GetMapping("/")
	public String index(Model model,Principal principal) { 
		SessionMember member =(SessionMember)httpSession.getAttribute("user");
		
		if(principal!= null && member == null) {
			Member userName = memberRepository.findByEmail(principal.getName());
			String name = userName.getNickname();
			model.addAttribute("name",name);
		}else if(principal != null && member != null ) {
			model.addAttribute("name",member.getNickname());
		}
	
		return "index";
	}
	
}

