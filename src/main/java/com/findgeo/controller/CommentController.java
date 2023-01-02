package com.findgeo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.findgeo.dto.CommentDto;

import com.findgeo.entity.Comment;
import com.findgeo.service.CommentService;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments/{boardid}")
	public List<Comment> readComment(@PathVariable Long boardid) throws Exception {
		return commentService.readComment(boardid);
	}

	@PostMapping("/comments/save")
	public Long create(@RequestBody Comment comment) {
		return commentService.create(comment);
	}

	@DeleteMapping("/comments/{id}")
	public void delete(@PathVariable Long id) {
		commentService.delete(id);
	}
}
