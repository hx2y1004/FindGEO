package com.findgeo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.findgeo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
	
	@Query("SELECT m from Member m where m.email = ?1")
	Optional<Member> findByEmails(@Param("email") String email);

//	@Query("update Member set nickname=:nickname, password=:password, email=:email, phone=:phone where email=:email")
//	void update(@Param("nickname") String nickname, @Param("password") String password, @Param("email") String email, @Param("phone") String phone);
}
