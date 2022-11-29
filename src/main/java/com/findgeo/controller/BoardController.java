package com.findgeo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.findgeo.service.*;
import com.findgeo.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class BoardController {
	public final PostService postService;
	
	@GetMapping("/board/boardlist")
	public String board(Model model) {
		model.addAttribute("posts",postService.findAllDesc());
		return "board/boardlist";
	}
	
	@GetMapping("/board/postssave")
	public String postsSave(Model model, Principal principal) {
		model.addAttribute("nickname",principal.getName());
		return "/board/postsSave";
	}
	
	//조회
	@GetMapping("/post/info/{boardid}")
	public String postsInfo(@PathVariable Long boardid, Model model) {
		PostsResponseDto dto = postService.findById(boardid);
		model.addAttribute("posts",dto);
		return "board/postsInfo";
	}
	
}
