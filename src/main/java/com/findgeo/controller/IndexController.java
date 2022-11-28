package com.findgeo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.findgeo.config.dto.SessionMember;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final HttpSession httpSession;

	@GetMapping("/")
	public String index(Model model,Principal principal) {
		SessionMember member =(SessionMember)httpSession.getAttribute("user");
		if(principal!= null && member == null) {
			model.addAttribute("name",principal.getName());
		}else if(principal != null && member != null ) {
			model.addAttribute("name",member.getEmail());
		}
	
		return "index";
	}
}

