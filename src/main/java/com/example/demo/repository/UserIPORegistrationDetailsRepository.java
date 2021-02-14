package com.example.demo.repository;

import com.example.demo.models.UserIPORegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * Created By : arshia on 05/02/21
 **/
public interface UserIPORegistrationDetailsRepository extends JpaRepository<UserIPORegistrationDetails, Long>, UserIPORegistrationRepositoryCustom {

    @Query(nativeQuery = true, value = "SELECT user.CONTACT_NUMBER, ipoDetails.NAME, userIPORegistration.CUT_OFF_PRICE, userIPORegistration.LOTS  from USER_IPO_REGISTRATION_DETAILS userIPORegistration INNER JOIN USER_MASTER user ON userIPORegistration.USER_ID=user.ID INNER JOIN IPO_DETAILS ipoDetails ON userIPORegistration.IPO_ID=ipoDetails.ID" +
            " where user.CONTACT_NUMBER=:#{#contactNumber}" +
            " ORDER BY userIPORegistration.CREATED_DATE DESC" )
    List<Object[]> findIPORegistrationDetailsByContact(@Param("contactNumber") String contactNumber);

    UserIPORegistrationDetails findByUserIdAndIpoId(BigInteger userId, BigInteger ipoId);
}
