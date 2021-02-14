package com.example.demo.repository;

import com.example.demo.models.IPODetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By : arshia on 05/02/21
 **/
public interface IPODetailsRepository extends JpaRepository<IPODetails, Long> {

    IPODetails findByName(String name);
}
