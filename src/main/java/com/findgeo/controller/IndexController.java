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
import com.nimbusds.openid.connect.sdk.claims.UserInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final HttpSession httpSession;

	@GetMapping("/")
	public String index(Model model,Principal principal) { 
		SessionMember member =(SessionMember)httpSession.getAttribute("user");
//	    Object principal2 = SecurityContextHolder.getContext().getAuthentication();
//	    UserInfo userInfo = (UserInfo)principal2;
		if(principal!= null && member == null) {
			model.addAttribute("name",principal.getName());
		}else if(principal != null && member != null ) {
			model.addAttribute("name",member.getNickname());
		}
	
		return "index";
	}
	
}

