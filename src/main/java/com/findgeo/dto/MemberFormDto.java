package com.findgeo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.findgeo.entity.Member;
import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

	@NotBlank(message = "닉네임을 입력해주세요.")
	private String nickname;

	@NotEmpty(message = "비밀번호를 입력해주세요.")
	@Length(min = 8, max = 16, message = "비밀번호는 8자이상, 16자 이하로 입력해주세요")
	private String password;

	@NotEmpty(message = "이메일을 입력해주세요.")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String email;

	@NotEmpty(message = "휴대폰 번호를 입력해주세요.")
	@Length(min = 10, max = 11, message = "휴대폰 번호를 확인해주세요.")
	private String phone;

	private String picture;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private static LocalDateTime createDate;

	@Builder
	public MemberFormDto(String nickname, String password, String email, String phone, String picture,
			LocalDateTime createDate) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.phone = phone;
		this.picture = picture;
		this.createDate = createDate;
	}

	public MemberFormDto() {
	}

	public static MemberFormDto toDto(Member member) {
		return MemberFormDto.builder().email(member.getEmail()).nickname(member.getNickname())
				.password(member.getPassword()).phone(member.getPhone()).picture(member.getPicture())
				.createDate(createDate).build();
	}

}
