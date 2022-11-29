package com.findgeo.config;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration.ProviderDetails.UserInfoEndpoint;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;
import com.findgeo.config.dto.OAuthAttributes;
import com.findgeo.config.dto.SessionMember;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;
    private final PasswordEncoder passwordEncoder; 	 

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
     
        // 현재 진행중인 서비스를 구분하기 위해 문자열로 받음. oAuth2UserRequest.getClientRegistration().getRegistrationId()에 값이 들어있다. {registrationId='naver'} 이런식으로
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // OAuth2 로그인 시 키 값이 된다. 구글은 키 값이 "sub"이고, 네이버는 "response"이고, 카카오는 "id"이다. 각각 다르므로 이렇게 따로 변수로 받아서 넣어줘야함.
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
        			.getUserInfoEndpoint().getUserNameAttributeName();
        
        
        // OAuth2 로그인을 통해 가져온 OAuth2User의 attribute를 담아주는 of 메소드.
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        System.out.println("어트리뷰트"+attributes.getAttributes());
        System.out.println("네임어트리뷰트키"+userNameAttributeName);
        System.out.println(userRequest.getClientRegistration().getProviderDetails()
        		.getUserInfoEndpoint().getUserNameAttributeName());
        
        Member mem = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionMember(mem));
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(mem.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private Member saveOrUpdate(OAuthAttributes attributes) {
    	Member member = memberRepository.findByEmail(attributes.getEmail());
    	if(member != null) {
    		Member mem = memberRepository.findByEmails(attributes.getEmail())
    				.map(entity -> entity.update(attributes.getNickname(), attributes.getNameAttributeKey(),
    						attributes.getEmail(),attributes.getPhone(), attributes.getPicture(), passwordEncoder))
    				.orElse(attributes.toEntity());
    		
    		return memberRepository.save(mem);
    	}else {

    		Member mem = memberRepository.findByEmails(attributes.getEmail())
                	.map(entity -> entity.createMember2(attributes.getNickname(), attributes.getNameAttributeKey(),
                			attributes.getEmail(), attributes.getPhone(), attributes.getPicture(), passwordEncoder))
                	.orElse(attributes.toEntity());

    		return memberRepository.save(mem);
    	}
    }



}
