package com.findgeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.findgeo.constant.Role;
import com.findgeo.dto.MemberFormDto;
import com.findgeo.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamicInsert
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

	private String nickname;
	
	@Id
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(columnDefinition = "varchar2(255) default '정보없음'")
	private String phone;
	
	@Column(columnDefinition = "varchar2(255) default '/images/기본프로필.jpg'")
	private String picture;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Builder
	public Member(String nickname, String email,String password, String phone, String picture, Role role){
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.picture = picture;
		this.role = role;
	}
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		System.out.println("멤버 추가 ");
		Member member = new Member();
		member.setNickname(memberFormDto.getNickname());
		member.setEmail(memberFormDto.getEmail());
		member.setPhone(memberFormDto.getPhone());
		String pw = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(pw);
		member.setPicture(memberFormDto.getPicture());
		member.setRole(Role.USER);
		return member;
	}
	
	public Member createMember2(String nickname, String password, String email, String phone, String picture, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setNickname(nickname);
		member.setEmail(email);
		String pw = passwordEncoder.encode(password);
		member.setPassword(pw);
		member.setPhone(phone);
		member.setPicture(picture);
		member.setRole(Role.USER);
		return member;
	}
	
	public Member update(String nickname, String password, String email, String phone, String picture, PasswordEncoder passwordEncoder) {
		this.nickname = nickname;
		String pw = passwordEncoder.encode(password);
		this.password = pw;
		this.phone = phone;
		this.email = email;
		this.picture = picture;
		return this;
		
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}

	
}
