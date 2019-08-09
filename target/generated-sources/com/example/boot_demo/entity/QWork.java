package com.example.boot_demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.example.boot_demo.core.entity.Work;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWork is a Querydsl query type for Work
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWork extends EntityPathBase<Work> {

    private static final long serialVersionUID = 1186625357L;

    public static final QWork work = new QWork("work");

    public final StringPath content = createString("content");

    public final StringPath marker = createString("marker");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public QWork(String variable) {
        super(Work.class, forVariable(variable));
    }

    public QWork(Path<? extends Work> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWork(PathMetadata metadata) {
        super(Work.class, metadata);
    }

}

