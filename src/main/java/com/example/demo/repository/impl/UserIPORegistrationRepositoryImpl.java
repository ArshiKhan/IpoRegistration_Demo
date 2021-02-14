package com.example.demo.repository.impl;

import com.example.demo.dto.UserIPORegistrationDto;
import com.example.demo.models.QUser;
import com.example.demo.models.QUserIPORegistrationDetails;
import com.example.demo.repository.UserIPORegistrationRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.QIPODetails;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created By : arshia on 05/02/21
 **/
public class UserIPORegistrationRepositoryImpl implements UserIPORegistrationRepositoryCustom {

    @Autowired
    @Qualifier("ipoJPAQueryFactory")
    private JPAQueryFactory queryFactory;

    @Override
    public List<Tuple> findIPORegistrationDetailsById(String contactNumber){
        QIPODetails iPODetails = QIPODetails.iPODetails;
        QUser user = QUser.user;
        QUserIPORegistrationDetails userIPORegistrationDetails = QUserIPORegistrationDetails.userIPORegistrationDetails;
        return queryFactory.select(iPODetails.name, userIPORegistrationDetails.cutOffPrice, userIPORegistrationDetails.lots).from(userIPORegistrationDetails)
                .innerJoin(userIPORegistrationDetails.user, user)
                .innerJoin(userIPORegistrationDetails.iPODetails, iPODetails)
                .where(user.contactNumber.eq(contactNumber).and(userIPORegistrationDetails.ipoId.eq(iPODetails.id))
                        .and(userIPORegistrationDetails.userId.eq(user.id)))
                .orderBy(userIPORegistrationDetails.createdTime.desc())
                .fetch();
    }

}
