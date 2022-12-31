package com.findgeo.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.findgeo.dto.SelectPingDto;
import com.findgeo.entity.Member;
import com.findgeo.entity.Posts;
import com.findgeo.repository.MemberRepository;
//import com.findgeo.util.Naver_Sens_V2;
import com.findgeo.repository.PostsRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	private final PostsRepository postRepository;

	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		System.out.println("멤버추가 22");
		return memberRepository.save(member);
	}

	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if (findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email);

		if (member == null) {
			throw new UsernameNotFoundException(email);
		}

		return User.builder().username(member.getEmail()).password(member.getPassword())
				.roles(member.getRole().toString()).build();
	}

	public String emailCheck(String email) {
		System.out.println(email + "여기는 ajax실험중 멤버서비스파일");
		Optional<Member> optionalMemberEntity = memberRepository.findByEmails(email);
		System.out.println(optionalMemberEntity + "ajax 실험중 여기는 멤버서비스");
		if (optionalMemberEntity.isEmpty()) {
			return "ok";
		} else {
			return "no";
		}
	}

	public void deletemember(Member member) {
		memberRepository.delete(member);
	}

	public void update(Member memberDto, MultipartFile file, PasswordEncoder passwordEncoder) throws Exception {
		memberRepository.save(Member.update(memberDto, file, passwordEncoder));
		// save라는 메소드는 db에있는 아이디가 있으면 업데이트 쿼리가 써진다.
	}

	public void update(String nickname, String password, String email, String phone, PasswordEncoder passwordEncoder)
			throws Exception {
		memberRepository.update(Member.update(nickname, password, email, phone, passwordEncoder).getNickname(),
				Member.update(nickname, password, email, phone, passwordEncoder).getPassword(),
				Member.update(nickname, password, email, phone, passwordEncoder).getEmail(),
				Member.update(nickname, password, email, phone, passwordEncoder).getPhone());
		// save라는 메소드는 db에있는 아이디가 있으면 업데이트 쿼리가 써진다.
	}

	public void deleteByEmail(String email) {
		memberRepository.deleteByEmail(email);
	}

	// 비밀번호 체크
	public boolean result(String password, String email, BCryptPasswordEncoder passwordEncoder) {
		System.out.println(password + "비번 체크 멤버서비스파일");
		String dbpw = memberRepository.findpw(email);
		System.out.println(dbpw + "ajax 실험중 여기는 멤버서비스");
		boolean dbpw2 = passwordEncoder.matches(password, dbpw);
		System.out.println(email + "이멜 서비스");
		System.out.println(password + "입력비번 서비스");
		System.out.println(dbpw2 + "불리언");
		return dbpw2;
	}

	// 마이페이지 내가 쓴 게시글 불러오기
	public List<Posts> selpostList(String email) {
		List<Posts> mypostList = postRepository.findBymypageSelfemail(email);
		return mypostList;
	}

}
