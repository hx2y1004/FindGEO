package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArmark is a Querydsl query type for Armark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArmark extends EntityPathBase<Armark> {

    private static final long serialVersionUID = -1528665626L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArmark armark = new QArmark("armark");

    public final StringPath arlat = createString("arlat");

    public final StringPath arlng = createString("arlng");

    public final NumberPath<Long> armarkid = createNumber("armarkid", Long.class);

    public final QClipping clipping;

    public QArmark(String variable) {
        this(Armark.class, forVariable(variable), INITS);
    }

    public QArmark(Path<? extends Armark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArmark(PathMetadata metadata, PathInits inits) {
        this(Armark.class, metadata, inits);
    }

    public QArmark(Class<? extends Armark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clipping = inits.isInitialized("clipping") ? new QClipping(forProperty("clipping")) : null;
    }

}

