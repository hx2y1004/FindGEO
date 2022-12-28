package com.findgeo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.findgeo.dto.CommentCreateRequest;
import com.findgeo.dto.CommentDto;
import com.findgeo.dto.CommentReadCondition;
import com.findgeo.service.CommentService;


import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;
	
    @GetMapping("/comments")
    public List<CommentDto> readAll(Long boardid) throws Exception {
        return commentService.readAll(boardid);
    }

    @PostMapping("/comments")
    public void create(@Valid @RequestBody CommentCreateRequest req) {
        commentService.create(req);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
