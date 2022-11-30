package com.findgeo.dto;

import java.time.LocalDateTime;

import com.findgeo.entity.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {
	private Long boardid;
	private String boardtitle;
	private String boardcontent;
	private String nickname;
	private LocalDateTime regdate;
	private int views;
	
	public PostsResponseDto(Posts entity) {
		this.boardid = entity.getBoardid();
		this.boardtitle =entity.getBoardtitle();
		this.boardcontent = entity.getBoardcontent();
		this.nickname = entity.getNickname();
		this.regdate = entity.getRegdate();
		this.views = entity.getViews();
	}
}
