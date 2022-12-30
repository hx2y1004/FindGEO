package com.findgeo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findgeo.dto.MyClipDto;
import com.findgeo.entity.Clipping;
import com.findgeo.entity.Trafmark;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public interface ClippingRepository extends JpaRepository<Clipping,String>{
	List<Clipping> findByEmail(String email);

	Clipping findByClipid(Long id);
	
	
	@Modifying
	@Transactional
	@Query("SELECT c from Clipping c where c.clipid = ?1")
	List<Clipping> findByClipidList(@Param("clipid") Long clipid);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Clipping c WHERE c.clipid = ?1")
	Integer delMyClip(@Param("clipid") Long clipid);
	
}
