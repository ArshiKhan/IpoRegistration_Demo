package com.example.demo.configs;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created By : arshia on 05/02/21
 **/
@Configuration
public class QueryDslConfig {

    @PersistenceContext(unitName = "ipo")
    //@PersistenceContext
    private EntityManager entityManager;

    @Bean(name = "ipoJPAQueryFactory")
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
