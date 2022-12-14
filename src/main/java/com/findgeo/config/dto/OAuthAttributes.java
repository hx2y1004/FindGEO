package com.findgeo.config.dto;

import java.util.Map;

import com.findgeo.entity.Member;
import com.findgeo.config.dto.OAuthAttributes;
import com.findgeo.constant.Role;

import lombok.Builder;
import lombok.Getter;
//import oracle.security.o3logon.a;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String nickname;
	private String email;
	private String phone;
	private String picture;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String nickname, String phone,
			String email, String picture) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.picture = picture;
	}

	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
			Map<String, Object> attributes) {
		if ("naver".equals(registrationId)) {
			return ofNaver("id", attributes);
		}

		if ("kakao".equals(registrationId)) {
			return ofkakao("profile", attributes);
		}

		return ofGoogle(userNameAttributeName, attributes);
	}

	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder().nickname((String) attributes.get("name"))
				.email((String) attributes.get("email")).picture((String) attributes.get("picture")).phone("정보없음")
				.attributes(attributes).nameAttributeKey(userNameAttributeName).build();
	}

	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		System.out.println(OAuthAttributes.builder().attributes(response).nameAttributeKey(userNameAttributeName));

		return OAuthAttributes.builder().nickname((String) response.get("name")).email((String) response.get("email"))
				.picture((String) response.get("profile_image")).phone("정보없음").attributes(response)
				.nameAttributeKey(userNameAttributeName).build();
	}

	private static OAuthAttributes ofkakao(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
		Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
		System.out.println(OAuthAttributes.builder().attributes(kakaoAccount).nameAttributeKey(userNameAttributeName));
		return OAuthAttributes.builder().nickname((String) profile.get("nickname"))
				.email((String) kakaoAccount.get("email")).picture((String) profile.get("profile_image_url"))
				.phone("정보없음").attributes(kakaoAccount).nameAttributeKey(userNameAttributeName).build();
	}

	public Member toEntity() {
		return Member.builder().nickname(nickname).email(email).password(nameAttributeKey).picture(picture).phone(phone)
				.role(Role.USER).build();
	}
}