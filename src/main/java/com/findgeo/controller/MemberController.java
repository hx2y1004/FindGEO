package com.findgeo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.MemberFormDto;
import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;
import com.findgeo.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	private final HttpSession httpSession;
	
	@GetMapping("/new")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());

		return "member/memberForm";
	}
	
	@PostMapping("/new")
	public String newMember(@Validated MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "member/memberForm";
		}
		try {
			Member member = Member.createMember(memberFormDto, passwordEncoder);
			httpSession.setAttribute("user", new SessionMember(member));
			System.out.println("멤버 저장");
			memberService.saveMember(member);
		}catch(IllegalStateException e){
			model.addAttribute("errorMessage",e.getMessage());
			return "member/memberForm";
		}
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String loginMember() {
		
		return "member/memberLoginForm";
	}
	
	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
		return "member/memberLoginForm";
	}
	
}
