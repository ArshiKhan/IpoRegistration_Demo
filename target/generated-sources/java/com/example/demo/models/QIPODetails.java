package com.example.demo.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIPODetails is a Querydsl query type for IPODetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIPODetails extends EntityPathBase<IPODetails> {

    private static final long serialVersionUID = 837114596L;

    public static final QIPODetails iPODetails = new QIPODetails("iPODetails");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> expiry = createDateTime("expiry", java.util.Date.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> lowerBandPrice = createNumber("lowerBandPrice", java.math.BigInteger.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final NumberPath<java.math.BigInteger> upperBandPrice = createNumber("upperBandPrice", java.math.BigInteger.class);

    public final SetPath<UserIPORegistrationDetails, QUserIPORegistrationDetails> userIPORegistrationDetails = this.<UserIPORegistrationDetails, QUserIPORegistrationDetails>createSet("userIPORegistrationDetails", UserIPORegistrationDetails.class, QUserIPORegistrationDetails.class, PathInits.DIRECT2);

    public QIPODetails(String variable) {
        super(IPODetails.class, forVariable(variable));
    }

    public QIPODetails(Path<? extends IPODetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIPODetails(PathMetadata metadata) {
        super(IPODetails.class, metadata);
    }

}

