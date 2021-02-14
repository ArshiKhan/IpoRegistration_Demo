package com.example.demo.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserIPORegistrationDetails is a Querydsl query type for UserIPORegistrationDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserIPORegistrationDetails extends EntityPathBase<UserIPORegistrationDetails> {

    private static final long serialVersionUID = -954798698L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserIPORegistrationDetails userIPORegistrationDetails = new QUserIPORegistrationDetails("userIPORegistrationDetails");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<java.math.BigInteger> cutOffPrice = createNumber("cutOffPrice", java.math.BigInteger.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QIPODetails iPODetails;

    public final NumberPath<java.math.BigInteger> ipoId = createNumber("ipoId", java.math.BigInteger.class);

    public final BooleanPath isCancelled = createBoolean("isCancelled");

    public final NumberPath<java.math.BigInteger> lots = createNumber("lots", java.math.BigInteger.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final QUser user;

    public final NumberPath<java.math.BigInteger> userId = createNumber("userId", java.math.BigInteger.class);

    public QUserIPORegistrationDetails(String variable) {
        this(UserIPORegistrationDetails.class, forVariable(variable), INITS);
    }

    public QUserIPORegistrationDetails(Path<? extends UserIPORegistrationDetails> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserIPORegistrationDetails(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserIPORegistrationDetails(PathMetadata metadata, PathInits inits) {
        this(UserIPORegistrationDetails.class, metadata, inits);
    }

    public QUserIPORegistrationDetails(Class<? extends UserIPORegistrationDetails> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.iPODetails = inits.isInitialized("iPODetails") ? new QIPODetails(forProperty("iPODetails")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

