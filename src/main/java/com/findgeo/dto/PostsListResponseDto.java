package com.findgeo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.findgeo.entity.*;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
	private Long boardid;
	private String boardtitle;
	private String boardcontent;
	private String nickname;
	private LocalDateTime regdate;

	
	public PostsListResponseDto(Posts posts) {
		this.boardid = posts.getBoardid();
		this.boardtitle = posts.getBoardtitle();
		this.boardcontent = posts.getBoardcontent();
		this.nickname = posts.getNickname();
		this.regdate = posts.getRegdate();
	}
}
