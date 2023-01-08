package com.findgeo.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.findgeo.entity.Comment;
import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
	private Long commentid;
	private String content;
	private Long boardid;
//	private Long parentid;
	private String email;
	private String pictuer;

	public CommentDto(Long commentid, String content, Long boardid, String email, String picture) {
		this.commentid = commentid;
		this.content = content;
		this.email = email;
		this.boardid = boardid;
//		this.parentid = parentid;
		this.pictuer = picture;

	}

}
