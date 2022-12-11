package com.findgeo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.MemberFormDto;
import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;
import com.findgeo.service.MemberService;
import com.findgeo.util.Script;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	private final HttpSession httpSession;
    private final MemberRepository memberRepository;
	
	@GetMapping("/new")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());

		return "member/memberForm";
	}
	
	@GetMapping("/memberLoginForm")
	public String newMember2(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());

		return "member/memberLoginForm";
	}
	
	@GetMapping("/memberForm")
	public String failMember2() {

		return "member/memberForm";
	}
	
	@PostMapping("/new")
	public @ResponseBody String newMember(@Validated MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			return Script.href("member/memberForm", "회원가입에 실패하였습니다.");
		}
		try {
			Member member = Member.createMember(memberFormDto, passwordEncoder);
			System.out.println("멤버 저장");
			memberService.saveMember(member);
		}catch(IllegalStateException e){
			model.addAttribute("errorMessage",e.getMessage());
			return Script.href("member/memberForm", "회원가입에 실패하였습니다.");
		}
		return Script.href("memberLoginForm","회원가입에 성공하였습니다.");
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
	
	//이메일 중복체크
    @GetMapping("/emailCheck")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String email) {
       System.out.println(email+"아이디 중복체크 ajax 실험중 여기는 멤버 컨트롤러");
       String checkResult = memberService.emailCheck(email);
       return checkResult;
    }
    
    @GetMapping("/mypage")
    public String myPage(Model model, Principal principal) {
    	SessionMember member =(SessionMember)httpSession.getAttribute("user");
    	if(principal!= null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			System.out.println("사진체크  "+user.getPicture());
			model.addAttribute("member",user);
		}else if(principal != null && member != null ) {
			model.addAttribute("member",member);
			model.addAttribute("loginInfo","social");
		}
    	return "mypage/mypage";
    }
    
    //수정화면 요청
    //내가 로그인한 거에서 내가 수정하는 것이기 때문에 세션값을 사용하는 것이다.
     @GetMapping("/update1")
     public String myPage1(Model model, Principal principal) {
        SessionMember member =(SessionMember)httpSession.getAttribute("user");
        if(principal!= null && member == null) {
          Member user = memberRepository.findByEmail(principal.getName());
          model.addAttribute("name",user);
          System.out.println(user.getPicture()+"12월2일 실험중ddd");
       }else if(principal != null && member != null ) {
          model.addAttribute("name",member);  
       }
        return "member/update";
     }
    
  //수정처리
     @PostMapping("/update3")
     public String update(@ModelAttribute Member memberDto, MultipartFile file, Model model,Principal principal) throws Exception{
//       Member memberDto = memberRepository.findByEmail(principal.getName());
    	 System.out.println(memberDto.getPicture());
    	 Member member = Member.update(memberDto, file, passwordEncoder);
    	 memberRepository.save(member);
    	 model.addAttribute("name",member.getNickname());
    	 return "redirect:/";
     }
    
}
