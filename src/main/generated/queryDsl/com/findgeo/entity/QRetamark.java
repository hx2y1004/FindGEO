package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRetamark is a Querydsl query type for Retamark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRetamark extends EntityPathBase<Retamark> {

    private static final long serialVersionUID = 941756437L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRetamark retamark = new QRetamark("retamark");

    public final QClipping clipping;

    public final StringPath retalat = createString("retalat");

    public final StringPath retalng = createString("retalng");

    public final NumberPath<Long> retamarkid = createNumber("retamarkid", Long.class);

    public QRetamark(String variable) {
        this(Retamark.class, forVariable(variable), INITS);
    }

    public QRetamark(Path<? extends Retamark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRetamark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRetamark(PathMetadata metadata, PathInits inits) {
        this(Retamark.class, metadata, inits);
    }

    public QRetamark(Class<? extends Retamark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clipping = inits.isInitialized("clipping") ? new QClipping(forProperty("clipping")) : null;
    }

}

