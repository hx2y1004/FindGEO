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
public interface CommentRepository extends JpaRepository<Comment, Long>{
	@Query("SELECT c FROM Comment c left join fetch c.parent where c.commentid = :commentid")
	Optional<Comment> findWithParentById(@Param("commentid") Long commentid);
	// 댓글 id 조회 부모와 fetch join 된 결과 반환
//	
//	@Query("select c from Comment c join fetch c.member left join fecth c.parent "
//			+ "where c.posts.boardid = :boardid "
//			+ "order by c.parent.commentid asc nulls first, c.commentid asc")
//	List<Comment> findAllWithMemberAndParentByPostIdORderByParenIdAscNullsFirstCommentIdAsc(@Param("boardid") Long boardid);
	//부모의 아이디로 오름차순 정렬 null우선적, 그다음 자신의 아이디로 오름차순 하여 정렬 
	

}
