package com.findgeo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class BoardDto {
	
	private Long boardid;
	private String boardtitle;
	private String boardcontent;
	private String nickname;
	private LocalDateTime regdate;

}
