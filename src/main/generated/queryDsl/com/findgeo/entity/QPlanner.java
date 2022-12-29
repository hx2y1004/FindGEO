package com.findgeo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlanner is a Querydsl query type for Planner
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlanner extends EntityPathBase<Planner> {

    private static final long serialVersionUID = 101185386L;

    public static final QPlanner planner = new QPlanner("planner");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Integer> advertise = createNumber("advertise", Integer.class);

    public final NumberPath<Integer> avgDayDeli = createNumber("avgDayDeli", Integer.class);

    public final NumberPath<Integer> avgDayVisit = createNumber("avgDayVisit", Integer.class);

    public final NumberPath<Integer> avgEndDeli = createNumber("avgEndDeli", Integer.class);

    public final NumberPath<Integer> avgEndVisit = createNumber("avgEndVisit", Integer.class);

    public final NumberPath<Integer> avgPrice = createNumber("avgPrice", Integer.class);

    public final StringPath category = createString("category");

    public final NumberPath<Float> costRate = createNumber("costRate", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Integer> days = createNumber("days", Integer.class);

    public final NumberPath<Integer> dues = createNumber("dues", Integer.class);

    public final StringPath emailId = createString("emailId");

    public final NumberPath<Integer> ends = createNumber("ends", Integer.class);

    public final NumberPath<Integer> etc = createNumber("etc", Integer.class);

    public final NumberPath<Integer> etcRent = createNumber("etcRent", Integer.class);

    public final NumberPath<Integer> expand = createNumber("expand", Integer.class);

    public final NumberPath<Integer> initCost = createNumber("initCost", Integer.class);

    public final NumberPath<Integer> interest = createNumber("interest", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Integer> partTime = createNumber("partTime", Integer.class);

    public final NumberPath<Long> plannerId = createNumber("plannerId", Long.class);

    public final StringPath plannerTitle = createString("plannerTitle");

    public final NumberPath<Integer> rentCost = createNumber("rentCost", Integer.class);

    public final NumberPath<Integer> totalSalary = createNumber("totalSalary", Integer.class);

    public final NumberPath<Integer> totInsurance = createNumber("totInsurance", Integer.class);

    public final NumberPath<Integer> w_e_g = createNumber("w_e_g", Integer.class);

    public QPlanner(String variable) {
        super(Planner.class, forVariable(variable));
    }

    public QPlanner(Path<? extends Planner> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlanner(PathMetadata metadata) {
        super(Planner.class, metadata);
    }

}

