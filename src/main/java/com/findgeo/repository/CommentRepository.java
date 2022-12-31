package com.findgeo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findgeo.dto.CommentDto;
import com.findgeo.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	@Query("SELECT c FROM Comment c where c.commentid = :commentid")
	Optional<Comment> findWithParentById(@Param("commentid") Long commentid);
	// 댓글 id 조회 부모와 fetch join 된 결과 반환

	@Query("SELECT c FROM Comment c where c.boardid = :boardid")
	List<Comment> findByBoardid(@Param("boardid") Long boardid);

}
