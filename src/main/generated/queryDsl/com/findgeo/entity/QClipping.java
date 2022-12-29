package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClipping is a Querydsl query type for Clipping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClipping extends EntityPathBase<Clipping> {

    private static final long serialVersionUID = -2108974550L;

    public static final QClipping clipping = new QClipping("clipping");

    public final StringPath areacate = createString("areacate");

    public final StringPath areagrade = createString("areagrade");

    public final StringPath areaname = createString("areaname");

    public final StringPath areaoption = createString("areaoption");

    public final StringPath category = createString("category");

    public final NumberPath<Long> clipid = createNumber("clipid", Long.class);

    public final StringPath congest = createString("congest");

    public final StringPath email = createString("email");

    public final NumberPath<Float> female = createNumber("female", Float.class);

    public final NumberPath<Float> male = createNumber("male", Float.class);

    public final NumberPath<Float> nonresnt = createNumber("nonresnt", Float.class);

    public final NumberPath<Float> rate0 = createNumber("rate0", Float.class);

    public final NumberPath<Float> rate10 = createNumber("rate10", Float.class);

    public final NumberPath<Float> rate20 = createNumber("rate20", Float.class);

    public final NumberPath<Float> rate30 = createNumber("rate30", Float.class);

    public final NumberPath<Float> rate40 = createNumber("rate40", Float.class);

    public final NumberPath<Float> rate50 = createNumber("rate50", Float.class);

    public final NumberPath<Float> rate60 = createNumber("rate60", Float.class);

    public final NumberPath<Float> rate70 = createNumber("rate70", Float.class);

    public final NumberPath<Float> resnt = createNumber("resnt", Float.class);

    public final StringPath selectlat = createString("selectlat");

    public final StringPath selectlng = createString("selectlng");

    public final StringPath seloption = createString("seloption");

    public final StringPath trafcate = createString("trafcate");

    public final StringPath trafoption = createString("trafoption");

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

