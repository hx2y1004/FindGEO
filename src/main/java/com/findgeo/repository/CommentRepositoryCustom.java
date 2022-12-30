package com.findgeo.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.findgeo.dto.CommentDto;
import com.findgeo.entity.Comment;

public interface CommentRepositoryCustom {
	List<CommentDto> findAllCommentFromParentid(Long boardid);
	
}
