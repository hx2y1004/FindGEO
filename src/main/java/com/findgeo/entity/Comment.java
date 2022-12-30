package com.findgeo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentid;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private Long boardid;
	
	private Long parentid;
	
	@Column(nullable = false)
	private String content;
	
	@Builder
	public Comment(String content, String email, String nickname, Long boardid, Long parentid) {
		this.boardid = boardid;
		this.content = content;
		this.email = email;
		this.nickname = nickname;
		this.parentid = parentid;
	}

	
	
}
