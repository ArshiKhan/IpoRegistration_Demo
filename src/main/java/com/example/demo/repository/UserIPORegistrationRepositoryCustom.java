package com.example.demo.repository;

import com.querydsl.core.Tuple;

import java.util.List;

/**
 * Created By : arshia on 05/02/21
 **/
public interface UserIPORegistrationRepositoryCustom {
    List<Tuple> findIPORegistrationDetailsById(String contactNumber);
}
