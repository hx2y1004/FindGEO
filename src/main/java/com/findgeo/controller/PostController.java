package com.findgeo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.findgeo.dto.PostsSaveRequestDto;
import com.findgeo.service.PostService;
import com.findgeo.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostController {
	private final PostService postService;
	
	@PostMapping("/post/boardsave")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postService.save(requestDto);
	}
	
	
}
