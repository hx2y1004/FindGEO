package com.findgeo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.findgeo.dto.PostsSaveRequestDto;
import com.findgeo.dto.PostsUpdateRequestDto;
import com.findgeo.service.CommentService;
import com.findgeo.service.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostController {
	private final PostService postService;
	private final CommentService commentService;

	@PostMapping("/post/boardsave")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postService.save(requestDto);
	}

	@PutMapping("/post/boardupdate/{boardid}")
	public Long update(@PathVariable Long boardid, @RequestBody PostsUpdateRequestDto requestDto) {
		return postService.update(boardid, requestDto);
	}

	@DeleteMapping("/post/boarddelete/{boardid}")
	public Long delete(@PathVariable Long boardid) {
		commentService.deleteByBoardid(boardid);
		postService.delete(boardid);
		return boardid;
	}

}
