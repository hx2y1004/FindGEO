package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = 1545470967L;

    public static final QComment comment = new QComment("comment");

    public final NumberPath<Long> boardid = createNumber("boardid", Long.class);

    public final NumberPath<Long> commentid = createNumber("commentid", Long.class);

    public final StringPath content = createString("content");

    public final StringPath email = createString("email");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Long> parentid = createNumber("parentid", Long.class);

    public QComment(String variable) {
        super(Comment.class, forVariable(variable));
    }

    public QComment(Path<? extends Comment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComment(PathMetadata metadata) {
        super(Comment.class, metadata);
    }

}

