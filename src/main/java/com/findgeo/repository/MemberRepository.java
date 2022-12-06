package com.findgeo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.findgeo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
	
	@Query("SELECT m from Member m where m.email = ?1")
	Optional<Member> findByEmails(@Param("email") String email);

}
