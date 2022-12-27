package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClipping is a Querydsl query type for Clipping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClipping extends EntityPathBase<Clipping> {

    private static final long serialVersionUID = -2108974550L;

    public static final QClipping clipping = new QClipping("clipping");

    public final StringPath areagrade = createString("areagrade");

    public final StringPath areaname = createString("areaname");

    public final ListPath<Armark, QArmark> armark = this.<Armark, QArmark>createList("armark", Armark.class, QArmark.class, PathInits.DIRECT2);

    public final NumberPath<Long> clipid = createNumber("clipid", Long.class);

    public final StringPath congest = createString("congest");

    public final StringPath email = createString("email");

    public final ListPath<Fdmark, QFdmark> fdmark = this.<Fdmark, QFdmark>createList("fdmark", Fdmark.class, QFdmark.class, PathInits.DIRECT2);

    public final NumberPath<Integer> female = createNumber("female", Integer.class);

    public final NumberPath<Integer> male = createNumber("male", Integer.class);

    public final NumberPath<Integer> nonresnt = createNumber("nonresnt", Integer.class);

    public final NumberPath<Integer> rate0 = createNumber("rate0", Integer.class);

    public final NumberPath<Integer> rate10 = createNumber("rate10", Integer.class);

    public final NumberPath<Integer> rate20 = createNumber("rate20", Integer.class);

    public final NumberPath<Integer> rate30 = createNumber("rate30", Integer.class);

    public final NumberPath<Integer> rate40 = createNumber("rate40", Integer.class);

    public final NumberPath<Integer> rate50 = createNumber("rate50", Integer.class);

    public final NumberPath<Integer> rate60 = createNumber("rate60", Integer.class);

    public final NumberPath<Integer> rate70 = createNumber("rate70", Integer.class);

    public final NumberPath<Integer> resnt = createNumber("resnt", Integer.class);

    public final ListPath<Retamark, QRetamark> retamark = this.<Retamark, QRetamark>createList("retamark", Retamark.class, QRetamark.class, PathInits.DIRECT2);

    public final StringPath selectlat = createString("selectlat");

    public final StringPath selectlng = createString("selectlng");

    public final ListPath<Svmark, QSvmark> svmark = this.<Svmark, QSvmark>createList("svmark", Svmark.class, QSvmark.class, PathInits.DIRECT2);

    public final ListPath<Trafmark, QTrafmark> trafmark = this.<Trafmark, QTrafmark>createList("trafmark", Trafmark.class, QTrafmark.class, PathInits.DIRECT2);

    public QClipping(String variable) {
        super(Clipping.class, forVariable(variable));
    }

    public QClipping(Path<? extends Clipping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClipping(PathMetadata metadata) {
        super(Clipping.class, metadata);
    }

}

