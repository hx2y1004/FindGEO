package com.findgeo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Posts {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long boardid;

@Column (length=500, nullable=false)
private String boardtitle;

@Column (length=2000, nullable=false)
private String boardcontent;

private String nickname;

@CreatedDate
@Column(updatable = false)
private LocalDateTime regdate = LocalDateTime.now();

@Builder
public Posts(String boardtitle, String boardcontent, String nickname) {
	this.boardtitle = boardtitle;
	this.boardcontent = boardcontent;
	this.nickname = nickname;
}

public void update(String boardtitle, String boardcontent) {
    this.boardtitle = boardtitle;
    this.boardcontent = boardcontent;
}

}
