package com.findgeo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.findgeo.dto.CommentDto;
import com.findgeo.entity.Comment;
import com.findgeo.entity.QComment;
import com.findgeo.entity.QMember;
import com.findgeo.entity.QPosts;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

	private final JPAQueryFactory queryFactory;
	
	@Override
	public List<CommentDto> findAllWithMemberAndParentByPostIdORderByParenIdAscNullsFirstCommentIdAsc(Long boardid) {
		
		QComment comment = QComment.comment;
		
		QPosts posts = QPosts.posts;
		
		QMember member = QMember.member;
		
		
		List<CommentDto> result = queryFactory.select(
				Projections.bean(CommentDto.class,
						comment.commentid,
						comment.content,
						comment.deleted,
						comment.posts,
						comment.children,
						comment.parent
						)
				)
				.from(comment)
				.join(member).on(comment.member.email.eq(member.email))
				.leftJoin(comment.parent).on(comment.parent.commentid.eq(comment.commentid))
				.where(comment.posts.boardid.eq(boardid))
				.fetch();
				
		return result;	
	}

	

}
