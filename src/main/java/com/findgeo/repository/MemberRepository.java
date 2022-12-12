package com.findgeo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.findgeo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
	
	@Query("SELECT m from Member m where m.email = ?1")
	Optional<Member> findByEmails(@Param("email") String email);
	
	@Transactional
	@Modifying 
	@Query("UPDATE Member m SET m.nickname=:nickname, m.password=:password, m.email=:email, m.phone=:phone WHERE m.email=:email")
	void update(@Param("nickname") String nickname,@Param("password") String password,@Param("email") String email,@Param("phone") String phone);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Member m WHERE m.email = ?1")
	Integer deleteByEmail(@Param("email") String email);
}
