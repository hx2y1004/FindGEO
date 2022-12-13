package com.findgeo.controller;
import java.security.Principal;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.findgeo.service.*;
import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.PostsResponseDto;
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
	
	@GetMapping("/board/boardlist")
	public String board(Model model, @RequestParam(required=false, defaultValue = "0",value="page") int page) {
		Page<Posts> listPage = postService.list(page);
		int totalPage = listPage.getTotalPages();
		
		model.addAttribute("posts",listPage.getContent());
		model.addAttribute("totalPage",totalPage);
		return "/board/boardlist";
	}
	//저장
	@GetMapping("/board/postssave")
	public String postsSave(Model model, Principal principal) throws Exception {
		SessionMember member =(SessionMember)httpSession.getAttribute("user");
    	if(principal!= null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			model.addAttribute("member",user);
		}else if(principal != null && member != null ) {
			model.addAttribute("member",member);
			model.addAttribute("loginInfo","social");
		}
		return "/board/postsSave";
	}
	
	//조회
	@GetMapping("/post/info/{boardid}")
	public String postsInfo(@PathVariable Long boardid, Model model) {
		postService.updateView(boardid); // views ++
		PostsResponseDto dto = postService.findById(boardid);
		model.addAttribute("posts",dto);
		return "/board/postsInfo";
	}
	
	//수정
	@GetMapping("/post/update/{boardid}")	
	public String postsUpdate(@PathVariable Long boardid, Model model) {
		PostsResponseDto dto = postService.findById(boardid);
		model.addAttribute("posts", dto);
		return "/board/postsUpdate";
	}

}
