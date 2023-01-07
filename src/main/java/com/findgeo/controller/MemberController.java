package com.findgeo.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.CheckSmsIdDto;
import com.findgeo.dto.MemberFormDto;
import com.findgeo.dto.MessageDto;
import com.findgeo.dto.PostsResponseDto;
import com.findgeo.dto.SmsResponseDto;
import com.findgeo.entity.Clipping;
import com.findgeo.entity.Member;
import com.findgeo.entity.Posts;
import com.findgeo.repository.MemberRepository;
import com.findgeo.service.ClippingService;
import com.findgeo.service.CommentService;
import com.findgeo.service.MemberService;
import com.findgeo.service.PlannerService;
import com.findgeo.service.PostService;
import com.findgeo.service.SmsService;
import com.findgeo.util.Script;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final PlannerService plannerService;
	private final CommentService commentService;
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	private final HttpSession httpSession;
	private final MemberRepository memberRepository;
	private final PostService postService;
	int chkNum = 0;
	private final ClippingService clippingService;

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
	public @ResponseBody String newMember(@Validated MemberFormDto memberFormDto, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return Script.href("member/memberForm", "회원가입에 실패하였습니다.");
		}
		try {
			Member member = Member.createMember(memberFormDto, passwordEncoder);
			System.out.println("멤버 저장");
			memberService.saveMember(member);
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return Script.href("member/memberForm", "회원가입에 실패하였습니다.");
		}
		return Script.href("memberLoginForm", "회원가입에 성공하였습니다.");
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

	// 이메일 중복체크
	@GetMapping("/emailCheck")
	public @ResponseBody String emailCheck(@RequestParam("memberEmail") String email) {
		String checkResult = memberService.emailCheck(email);
		return checkResult;
	}

	@GetMapping("/mypage")
	public String myPage(Model model, Principal principal) {
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		if (principal != null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			String email = user.getEmail();
			List<Clipping> clipList = clippingService.selClipList(email);
			model.addAttribute("clipList", clipList);
			model.addAttribute("member", user);
		} else if (principal != null && member != null) {
			String email = member.getEmail();
			List<Clipping> clipList = clippingService.selClipList(email);
			model.addAttribute("clipList", clipList);
			model.addAttribute("member", member);
			model.addAttribute("loginInfo", "social");
		}
		return "mypage/mypage";
	}

	// 마이페이지 내가 쓴 게시글 리스트로 불러오기
	@GetMapping(value = { "/mypage/detail/{email}", "/mypage/detail/{email}/{page}" })
	public String myContents(Principal principal, Model model, @PathVariable String email,
			@PathVariable("page") Optional<Integer> page) {

		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
		Page<Posts> mypostList = memberService.selectPostList(email, pageable);
		// List<Posts> mypostList = memberService.selpostList(email);
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		String emailId = "";
		if (principal != null && member == null) {
			emailId = principal.getName();
		} else if (principal != null && member != null) {
			emailId = member.getEmail();
		} else {
			model.addAttribute("message", "다시 로그인 해주세요");
			return "redirect:/";
		}
		model.addAttribute("email", emailId);
		model.addAttribute("mypostList", mypostList);
		model.addAttribute("maxPage", 5);

		return "mypage/mypagedetail";
	}

	// 수정화면 요청
	@GetMapping("/update1")
	public String myPage1(Model model, Principal principal) {
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		if (principal != null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			model.addAttribute("name", user);
		} else if (principal != null && member != null) {
			model.addAttribute("name", member);
		}
		return "member/update";
	}

	// 수정처리
	@PostMapping("/update3")
	public String update(@ModelAttribute Member memberDto, MultipartFile file, Model model, Principal principal)
			throws Exception {
		// memberDto = memberRepository.findByEmail(memberDto.getEmail());
		if (file.getOriginalFilename() != "") {
			Member member = Member.update(memberDto, file, passwordEncoder);
			memberRepository.save(member);
			model.addAttribute("name", member.getNickname());
		} else {
			Member member = Member.update(memberDto.getNickname(), memberDto.getPassword(), memberDto.getEmail(),
					memberDto.getPhone(), passwordEncoder);
			memberRepository.update(member.getNickname(), member.getPassword(), member.getEmail(), member.getPhone());
			model.addAttribute("name", member.getNickname());
		}
		return "redirect:/";
	}

	@GetMapping("/delete/{email}")
	public String deleteById(@PathVariable String email, Model model, Principal principal) {

		plannerService.plannerDeleteByEmail(email);
		commentService.commentDeleteByEmail(email);
		postService.postDeleteByEmail(email);
		clippingService.clippingDeleteByEmail(email);

		memberService.deleteByEmail(email);
		Member userEmail = memberRepository.findByEmail(principal.getName());
		model.addAttribute("name", userEmail);
		return "redirect:/members/logout";
	}

	// 비밀번호 체크
	@GetMapping("/pwCheck")
	public @ResponseBody boolean pwCheck(@RequestParam("password") String password, @RequestParam("email") String email,
			BCryptPasswordEncoder passwordEncoder) {
		boolean checkResult = memberService.result(password, email, passwordEncoder);
		return checkResult;
	}

	@GetMapping("/findId")
	public String findId() {
		return "member/findId";
	}

	private final SmsService smsService;

	@PostMapping("/sendsmsId")
	public @ResponseBody String sendSmsId(@RequestBody MessageDto messageDto, Model model) throws Exception {
		SmsResponseDto response = smsService.sendSms(messageDto);
		chkNum = smsService.chkNum();
		model.addAttribute("checkNum", chkNum);
		model.addAttribute("response", response);
		return "member/findId";
	}

	@GetMapping("/viewId/{phone}")
	public String viewId(@PathVariable String phone, Model model) {
		List<String> email = memberRepository.findIdByPhone(phone);
		model.addAttribute("email", email);
		return "member/foundId";
	}

	@GetMapping("/findPw")
	public String findPw() {
		return "member/findPw";
	}

	@PostMapping("/sendsmsPw")
	public @ResponseBody String sendSmsPw(@RequestBody MessageDto messageDto, Model model) throws Exception {
		SmsResponseDto response = smsService.sendSms(messageDto);
		chkNum = smsService.chkNum();
		System.out.println(messageDto.getEmail());
		System.out.println(messageDto.getTo());
		model.addAttribute("checkNum", chkNum);
		model.addAttribute("response", response);

		return "member/findPw";
	}

	@GetMapping("/changePw/{phone}")
	public String changePw(@PathVariable String phone, Model model) {
		List<String> email = memberRepository.findIdByPhone(phone);
		System.out.println(email + "멤버 컨트롤러 이멜 확인");
		model.addAttribute("email", email);
		System.out.println(model.getAttribute("email") + "멤버 컨트롤러 모델 이멜");
		return "member/changePw";
	}

	@PostMapping("/foundPw")
	public String changePw(@ModelAttribute Member memberDto, Model model, Principal principal) throws Exception {
		System.out.println(memberDto.getEmail() + "foundPw 이멜");
		Member member = Member.update(memberDto.getPassword(), memberDto.getEmail(), passwordEncoder);
		System.out.println(member.getPassword() + "cont1");
		System.out.println(member.getEmail());
		memberRepository.update(member.getPassword(), member.getEmail());
		model.addAttribute("email", member.getEmail());
		model.addAttribute("password", member.getPassword());
		System.out.println(model.getAttribute("password") + "cont2");
		return "member/memberLoginForm";
	}

	@PostMapping("/chksendid")
	public @ResponseBody String chkSendId(@RequestBody CheckSmsIdDto checkSmsIdDto) {

		String chkStnum = Integer.toString(chkNum);
		return chkStnum;
	}

	@PostMapping("/chkmember")
	public @ResponseBody String chkmember(@RequestBody MessageDto messageDto) {
		Member member = memberRepository.findByEmailPhone(messageDto.getEmail(), messageDto.getTo());
		System.out.println(messageDto.getEmail());
		System.out.println(messageDto.getTo());
		System.out.println(member + "컨트롤러");
		if (member != null) {
			return "true";
		} else {
			return "false";
		}
	}

	@GetMapping("/clipping/myclip/{clipid}")
	public String myclip(Model model, @PathVariable Long clipid) {
		System.out.println(clipid);
		int isClipPresent = clippingService.isClipPresent(clipid);
		if (isClipPresent == 1) {
			List<Clipping> myClipList = clippingService.selMyClip(clipid);
			model.addAttribute("mycliplist", myClipList);

			return "mypage/clip";
		} else {
			return "redirect:/members/mypage";
		}
	}

	@GetMapping("/clipping/myclip/delete/{clipid}")
	public String delmyclip(Model model, @PathVariable Long clipid, Principal principal) {
		System.out.println(clipid);
		int delchk = clippingService.delMyClip(clipid);
		model.addAttribute("delchk", delchk);
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		if (principal != null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			String email = user.getEmail();
			List<Clipping> clipList = clippingService.selClipList(email);
			model.addAttribute("clipList", clipList);
			model.addAttribute("member", user);
		} else if (principal != null && member != null) {
			String email = member.getEmail();
			List<Clipping> clipList = clippingService.selClipList(email);
			model.addAttribute("clipList", clipList);
			model.addAttribute("member", member);
			model.addAttribute("loginInfo", "social");
		}
		return "mypage/mypage";
	}

}
