package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By : arshia on 05/02/21
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailOrContactNumber(String email, String contactNumber);

    User findByContactNumber(String contactNumber);
}
