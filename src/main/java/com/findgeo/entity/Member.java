package com.findgeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.findgeo.constant.Role;
import com.findgeo.dto.MemberFormDto;
import com.findgeo.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nickname;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Builder
	public Member(String nickname, String email,String password, Role role){
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		System.out.println("멤버 추가 ");
		Member member = new Member();
		member.setNickname(memberFormDto.getNickname());
		member.setEmail(memberFormDto.getEmail());
		String pw = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(pw);
		member.setRole(Role.USER);
		return member;
	}
	
	public Member createMember2(String nickname, String password, String email, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setNickname(nickname);
		member.setEmail(email);
		String pw = passwordEncoder.encode(password);
		member.setPassword(pw);
		member.setRole(Role.USER);
		return member;
	}
	
	public Member update(String nickname, String password, String email, PasswordEncoder passwordEncoder) {
		this.nickname = nickname;
		String pw = passwordEncoder.encode(password);
		this.password = pw;
		this.email = email;
		return this;
		
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}

	
	
}
