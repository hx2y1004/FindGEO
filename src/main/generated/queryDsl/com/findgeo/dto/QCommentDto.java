package com.findgeo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.findgeo.dto.QCommentDto is a Querydsl Projection type for CommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCommentDto extends ConstructorExpression<CommentDto> {

    private static final long serialVersionUID = 983174994L;

    public QCommentDto(com.querydsl.core.types.Expression<Long> commentid, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<? extends MemberFormDto> member, com.querydsl.core.types.Expression<? extends java.util.List<CommentDto>> children) {
        super(CommentDto.class, new Class<?>[]{long.class, String.class, MemberFormDto.class, java.util.List.class}, commentid, content, member, children);
    }

}

