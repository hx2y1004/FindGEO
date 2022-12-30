package com.findgeo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.findgeo.dto.CommentDto;
import com.findgeo.entity.Comment;
import com.findgeo.entity.QClipping;
import com.findgeo.entity.QComment;
import com.findgeo.entity.QMember;
import com.findgeo.entity.QPosts;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

	private final JPAQueryFactory queryFactory;

	@Override
	public List<CommentDto> findAllCommentFromParentid(Long boardid) {
		QComment comment1 = QComment.comment;
		QComment comment2 = QComment.comment;
		
		List<CommentDto> result = queryFactory.select(
				Projections.constructor(CommentDto.class,
					comment1.boardid,
					comment1.commentid,
					comment1.content,
					comment1.email,
					
					comment1.parentid
					)
				)
				.from(comment1)
				.join(comment2).on(comment2.commentid.eq(comment1.commentid))
				.where(comment1.boardid.eq(boardid))
				.fetch();
				
		return null;	
	}

	

}
