package com.findgeo.repository;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findgeo.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
	@Query("SELECT p FROM Posts p ORDER BY p.boardid DESC")
	List<Posts> findAllDesc();

	@Modifying
	@Query("update Posts p set p.views = p.views + 1 where p.boardid = :boardid")
	int updateView(@Param("boardid") Long boardid);

	// 마이페이지 내가 쓴글게시글 불러오기 쿼리 짜보자
	@Modifying
	@Transactional
	@Query("Select p from Posts p where p.email = ?1")
	List<Posts> findBymypageSelfemail(@Param("email") String email);

	// Containing을 붙이면 like 검색
	List<Posts> findByBoardtitleContaining(String keyword);

}