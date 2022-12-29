package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPosts is a Querydsl query type for Posts
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPosts extends EntityPathBase<Posts> {

    private static final long serialVersionUID = -1282467989L;

    public static final QPosts posts = new QPosts("posts");

    public final StringPath boardcontent = createString("boardcontent");

    public final NumberPath<Long> boardid = createNumber("boardid", Long.class);

    public final StringPath boardtitle = createString("boardtitle");

    public final ListPath<Comment, QComment> commets = this.<Comment, QComment>createList("commets", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath fileinput = createString("fileinput");

    public final StringPath nickname = createString("nickname");

    public final DateTimePath<java.time.LocalDateTime> regdate = createDateTime("regdate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QPosts(String variable) {
        super(Posts.class, forVariable(variable));
    }

    public QPosts(Path<? extends Posts> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPosts(PathMetadata metadata) {
        super(Posts.class, metadata);
    }

}

