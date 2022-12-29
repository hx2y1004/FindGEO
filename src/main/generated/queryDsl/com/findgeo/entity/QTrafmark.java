package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrafmark is a Querydsl query type for Trafmark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrafmark extends EntityPathBase<Trafmark> {

    private static final long serialVersionUID = -1754280488L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrafmark trafmark = new QTrafmark("trafmark");

    public final QClipping clipping;

    public final StringPath traflat = createString("traflat");

    public final StringPath traflng = createString("traflng");

    public final NumberPath<Long> trafmarkid = createNumber("trafmarkid", Long.class);

    public QTrafmark(String variable) {
        this(Trafmark.class, forVariable(variable), INITS);
    }

    public QTrafmark(Path<? extends Trafmark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrafmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrafmark(PathMetadata metadata, PathInits inits) {
        this(Trafmark.class, metadata, inits);
    }

    public QTrafmark(Class<? extends Trafmark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clipping = inits.isInitialized("clipping") ? new QClipping(forProperty("clipping")) : null;
    }

}

