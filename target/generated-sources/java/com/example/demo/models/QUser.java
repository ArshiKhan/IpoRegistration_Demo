package com.example.demo.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 237897013L;

    public static final QUser user = new QUser("user");

    public final StringPath contactNumber = createString("contactNumber");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final StringPath name = createString("name");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final SetPath<UserIPORegistrationDetails, QUserIPORegistrationDetails> userIPORegistrationDetails = this.<UserIPORegistrationDetails, QUserIPORegistrationDetails>createSet("userIPORegistrationDetails", UserIPORegistrationDetails.class, QUserIPORegistrationDetails.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

