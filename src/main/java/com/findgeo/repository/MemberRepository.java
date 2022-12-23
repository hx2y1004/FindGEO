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
	
	@Transactional
	@Query("SELECT M.password FROM Member M WHERE M.email = ?1")
	String findpw(@Param("email") String email);

	
	@Transactional
	@Query("SELECT M.email from Member M WHERE M.phone = ?1")
	String findIdByPhone(@Param("phone") String phone);
	
	@Transactional
	@Query("SELECT M FROM Member M where M.email=?1 and M.phone=?2")
	Member findByEmailPhone(@Param("email") String email, @Param("phone") String phone);
	
	@Transactional
	@Modifying(clearAutomatically = true) 
	@Query("UPDATE Member m SET m.password=:password WHERE m.email=:email")
	void update(@Param("password") String password,@Param("email") String email);

}
