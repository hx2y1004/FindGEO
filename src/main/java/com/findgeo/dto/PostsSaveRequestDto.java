package com.findgeo.dto;

import com.findgeo.entity.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsSaveRequestDto {
	private String boardtitle;
	private String boardcontent;
	private String nickname;
	private String email;

	@Builder
	public PostsSaveRequestDto(String boardtitle, String boardcontent, String nickname, String email) {
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.nickname = nickname;
		this.email = email;

	}

	public Posts toPosts() {
		return Posts.builder().boardtitle(boardtitle).boardcontent(boardcontent).nickname(nickname).email(email)
				.email(email).build();
		// 빌더 패턴 각각 생성자로 객체 생성
	}

	public Posts toEntity() {
		return Posts.builder().boardtitle(boardtitle).boardcontent(boardcontent).build();
	}
}