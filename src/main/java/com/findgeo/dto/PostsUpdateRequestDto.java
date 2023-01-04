package com.findgeo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	private String boardtitle;
	private String boardcontent;

	@Builder
	public PostsUpdateRequestDto(String boardtitle, String boardcontent) {
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
	}
}