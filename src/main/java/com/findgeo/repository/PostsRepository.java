package com.findgeo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.findgeo.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {
	@Query ("SELECT p FROM Posts p ORDER BY p.boardid DESC")
	List<Posts> findAllDesc();
}
