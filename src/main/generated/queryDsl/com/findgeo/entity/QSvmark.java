package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSvmark is a Querydsl query type for Svmark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSvmark extends EntityPathBase<Svmark> {

    private static final long serialVersionUID = -1009646824L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSvmark svmark = new QSvmark("svmark");

    public final QClipping clipping;

    public final StringPath svlat = createString("svlat");

    public final StringPath svlng = createString("svlng");

    public final NumberPath<Long> svmarkid = createNumber("svmarkid", Long.class);

    public QSvmark(String variable) {
        this(Svmark.class, forVariable(variable), INITS);
    }

    public QSvmark(Path<? extends Svmark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSvmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSvmark(PathMetadata metadata, PathInits inits) {
        this(Svmark.class, metadata, inits);
    }

    public QSvmark(Class<? extends Svmark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clipping = inits.isInitialized("clipping") ? new QClipping(forProperty("clipping")) : null;
    }

}

