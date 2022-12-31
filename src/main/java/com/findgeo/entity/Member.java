package com.findgeo.entity;

import java.io.File;
import java.security.Principal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import org.springframework.web.multipart.MultipartFile;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.findgeo.constant.Role;
import com.findgeo.dto.MemberFormDto;
import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;

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

	@Column(columnDefinition = "varchar(255) default '정보없음'")
	private String phone;

	private String filePath;

	@Column(columnDefinition = "varchar(1000) default '/images/기본프로필.jpg'")
	private String picture;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Builder
	public Member(String nickname, String email, String password, String phone, String picture, Role role) {
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

	public Member createMember2(String nickname, String password, String email, String phone, String picture,
			PasswordEncoder passwordEncoder) {
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

	public Member update(String nickname, String password, String email, String phone, String picture,
			PasswordEncoder passwordEncoder) {
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

	public Member delete(String email) {
		this.email = email;
		return this;
	}

	public static Member update(Member memberDto1, MultipartFile file, PasswordEncoder passwordEncoder)
			throws Exception {
		Member memberEntity = new Member();

		memberEntity.setEmail(memberDto1.getEmail());
		memberEntity.setNickname(memberDto1.getNickname());
		String pw = passwordEncoder.encode(memberDto1.getPassword());
		memberEntity.setPassword(pw);
		memberEntity.setPhone(memberDto1.getPhone());
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";
		UUID uuid = UUID.randomUUID();
		String fileName = uuid + "_" + file.getOriginalFilename();
		File saveFile = new File(projectPath, fileName);
		file.transferTo(saveFile);
		memberDto1.setPicture("/images/" + fileName);
		memberDto1.setFilePath("/images" + fileName);
		memberEntity.setPicture(memberDto1.getPicture());
		memberEntity.setRole(memberDto1.getRole());
		return memberEntity;
	}

	public static Member update(String nickname, String password, String email, String phone,
			PasswordEncoder passwordEncoder) throws Exception {
		Member memberEntity = new Member();
		memberEntity.setEmail(email);
		memberEntity.setNickname(nickname);
		String pw = passwordEncoder.encode(password);
		memberEntity.setPassword(pw);
		memberEntity.setPhone(phone);

		return memberEntity;
	}

	// 비밀번호 변경 메서드
	public void updatePassword(String password) {
		this.password = password;
	}

	public static Member update(String password, String email, PasswordEncoder passwordEncoder) throws Exception {
		Member member = new Member();
		member.setEmail(email);
		String pw = passwordEncoder.encode(password);
		member.setPassword(pw);
		System.out.println(pw + "member entity");

		return member;
	}
}