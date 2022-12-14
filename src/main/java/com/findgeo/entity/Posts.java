package com.findgeo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import com.findgeo.dto.PostsSaveRequestDto.PostsSaveRequestDtoBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@Entity
@Getter
@NoArgsConstructor
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long boardid;

	@Column(length = 500, nullable = false)
	private String boardtitle;

	@Column(length = 2000, nullable = false)
	private String boardcontent;

	private String nickname;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime regdate = LocalDateTime.now();

	@Column(columnDefinition = "integer default 0", nullable = false) // 조회수의 기본 값을 0으로 지정, null 불가 처리
	private int views;

	@Column(length = 500)
	private String email;

	@Builder
	public Posts(String boardtitle, String boardcontent, String nickname, int views, String email) {
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.nickname = nickname;
		this.email = email;
		this.views = views;

	}

	public void update(String boardtitle, String boardcontent) {
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
	}

}