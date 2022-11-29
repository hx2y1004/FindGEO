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
	
	@Builder
	public PostsSaveRequestDto(String boardtitle, String boardcontent, String nickname) {
			this.boardtitle = boardtitle;
			this.boardcontent = boardcontent;
			this.nickname = nickname;
	}
	
	public Posts toPosts() {
		return Posts.builder()
				.boardtitle(boardtitle)
				.boardcontent(boardcontent)
				.nickname(nickname)
				.build();
		// 빌더 패턴 각각 생성자로 객체 생성
	}
	
	public Posts toEntity() {
		return Posts.builder().boardtitle(boardtitle).boardcontent(boardcontent).build();
	}
}
