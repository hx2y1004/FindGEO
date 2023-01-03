package com.findgeo.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.findgeo.service.*;
import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.PostsResponseDto;
import com.findgeo.dto.postSearchDto;
import com.findgeo.entity.Member;
import com.findgeo.entity.Posts;
import com.findgeo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	public final PostService postService;
	private final HttpSession httpSession;
	private final MemberRepository memberRepository;

	@GetMapping(value = { "/board/boardlist", "/board/boardlist/{page}" })
	public String boardlist(postSearchDto postSearchDto, Model model, @PathVariable("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
		Page<Posts> posts = postService.ListPage(postSearchDto, pageable);
		int postsTotal = postService.countPosts();
		System.out.println(postsTotal);
		model.addAttribute("postsTotal", postsTotal);
		model.addAttribute("posts", posts);
		model.addAttribute("maxPage", 5);
		return "board/boardlist";
	}

	// 저장
	@GetMapping("/board/postssave")
	public String postsSave(Model model, Principal principal) throws Exception {
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		if (principal != null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			model.addAttribute("member", user);
		} else if (principal != null && member != null) {
			model.addAttribute("member", member);
			model.addAttribute("loginInfo", "social");
		}
		return "/board/postsSave";
	}

	@GetMapping("/post/info/{boardid}")
	public String postsInfo(@PathVariable Long boardid, Model model, Principal principal) {
		postService.updateView(boardid); // views ++
		int isPostExist = postService.isPostExist(boardid);
		if(isPostExist==1) {
			
			PostsResponseDto dto = postService.findById(boardid);
			Member member = memberRepository.findByEmail(dto.getEmail());
			
			String email = member.getEmail();
			
			// @를 기준으로 문자열을 추출할 것.
			String sub_email = member.getEmail();
			// 먼저 @의 인덱스를 찾는다.
			int idx = sub_email.indexOf("@");
			// @ 앞 부분을 추출
			String sub_Email = sub_email.substring(0, idx) + "@******";
			System.out.println(sub_Email + "@*****이거 해도되냐 썅!!!!!!!??????????");
			SessionMember mem = (SessionMember) httpSession.getAttribute("user");
			if (principal != null && mem == null) {
				Member user = memberRepository.findByEmail(principal.getName());
				model.addAttribute("member", user);
			} else if (principal != null && mem != null) {
				model.addAttribute("member", mem);
				model.addAttribute("loginInfo", "social");
			}
			
			if (principal.getName().equals(email)) {
				model.addAttribute("check", true);
			}
			System.out.println(principal.getName() + "====");
			System.out.println(email + "*****");
			model.addAttribute("posts", dto);
			model.addAttribute("sub_Email", sub_Email);
			
			return "/board/postsInfo";
		} else {
			return "redirect:/board/boardlist";
		}
	}

	// 수정
	@GetMapping("/post/update/{boardid}")
	public String postsUpdate(@PathVariable Long boardid, Model model) {
		PostsResponseDto dto = postService.findById(boardid);
		model.addAttribute("posts", dto);
		return "/board/postsUpdate";
	}


}
