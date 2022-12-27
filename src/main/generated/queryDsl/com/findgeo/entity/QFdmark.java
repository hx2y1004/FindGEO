package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFdmark is a Querydsl query type for Fdmark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFdmark extends EntityPathBase<Fdmark> {

    private static final long serialVersionUID = -1398449165L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFdmark fdmark = new QFdmark("fdmark");

    public final QClipping clipping;

    public final StringPath fdlat = createString("fdlat");

    public final StringPath fdlng = createString("fdlng");

    public final NumberPath<Long> fdmarkid = createNumber("fdmarkid", Long.class);

    public QFdmark(String variable) {
        this(Fdmark.class, forVariable(variable), INITS);
    }

    public QFdmark(Path<? extends Fdmark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFdmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFdmark(PathMetadata metadata, PathInits inits) {
        this(Fdmark.class, metadata, inits);
    }

    public QFdmark(Class<? extends Fdmark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clipping = inits.isInitialized("clipping") ? new QClipping(forProperty("clipping")) : null;
    }

}

