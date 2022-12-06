package com.findgeo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.findgeo.entity.Member;
import com.findgeo.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MemberService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		System.out.println("멤버추가 22");
		return memberRepository.save(member);
	}
	
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email);
		
		if(member == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return User.builder()
				.username(member.getEmail())
				.password(member.getPassword())
				.roles(member.getRole().toString())
				.build();
	}
	
	public String emailCheck(String email) {
		System.out.println(email+ "여기는 ajax실험중 멤버서비스파일");
		Optional<Member> optionalMemberEntity =memberRepository.findByEmails(email);
		System.out.println(optionalMemberEntity+"ajax 실험중 여기는 멤버서비스");
		if(optionalMemberEntity.isEmpty()) {
		   return "ok";
		}else {
		   return "no";
		}
	}
	
	public void deletemember(Member member) {
		memberRepository.delete(member);
	}
	
	public void update(Member memberDto, PasswordEncoder passwordEncoder) {
	      memberRepository.save(Member.update(memberDto, passwordEncoder));
	      //save라는 메소드는 db에있는 아이디가 있으면 업데이트 쿼리가 써진다.
	}
}
