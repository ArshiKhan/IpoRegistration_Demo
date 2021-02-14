package com.example.demo.services;

import com.example.demo.dto.UserIPORegistrationDto;
import com.example.demo.exceptions.runtimeExceptions.BadRequestException;
import com.example.demo.exceptions.runtimeExceptions.EntityNotFoundException;
import com.example.demo.models.IPODetails;
import com.example.demo.models.User;
import com.example.demo.models.UserIPORegistrationDetails;
import com.example.demo.repository.UserIPORegistrationDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created By : arshia on 05/02/21
 **/
@Service
public class UserRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private IPOService ipoService;

    @Autowired
    private UserIPORegistrationDetailsRepository userIPORegistrationDetailsRepository;

    public List<UserIPORegistrationDto> getUserIPORegistrationDetails(String contactNumber) {
        logger.info("Getting user details for contact number : {}", contactNumber);

        List<UserIPORegistrationDto> userIPORegistrationDtoList = new ArrayList<>();

        List<Object[]> objects = userIPORegistrationDetailsRepository.findIPORegistrationDetailsByContact(contactNumber);

        if (CollectionUtils.isEmpty(objects)) {
            logger.error("No ipo registration details found for contact number : {}", contactNumber);
            throw new EntityNotFoundException("No ipo registration details found for contact number : "+contactNumber);
        }

        Object[] ipoRegistration = objects.get(0);
        logger.info("Found {} ipo user details for contact number : {}", ipoRegistration.length, contactNumber);
        UserIPORegistrationDto userIPORegistrationDto = new UserIPORegistrationDto();
        userIPORegistrationDto.setLotsApplied((BigInteger) ipoRegistration[3]);
        userIPORegistrationDto.setCutOffPrice((BigInteger)ipoRegistration[2]);
        userIPORegistrationDto.setIpoName((String)ipoRegistration[1]);
        userIPORegistrationDto.setContactNumber((String)ipoRegistration[0]);
        userIPORegistrationDtoList.add(userIPORegistrationDto);


        return userIPORegistrationDtoList;
    }

    public String registerForIPO(UserIPORegistrationDto userIPORegistrationDto) {
        logger.info("Registering user for IPO with contact number : {}", userIPORegistrationDto.getContactNumber());

        User user = userService.getUser(userIPORegistrationDto.getContactNumber());
        if(Objects.isNull(user)){
            logger.error("No registered user found in the system. Try Again!");
            throw new BadRequestException("No registered user found in the system. Try Again!");
        }

        IPODetails ipoDetails = ipoService.getIPODetailsByName(userIPORegistrationDto.getIpoName());

        if(Objects.isNull(ipoDetails)){
            logger.error("No valid ipo found in the system. Try Again!");
            throw new BadRequestException("No valid ipo found in the system. Try Again!");
        }

        UserIPORegistrationDetails userIPORegistrationDetails = userIPORegistrationDetailsRepository.findByUserIdAndIpoId(user.getId(), ipoDetails.getId());

        if(Objects.nonNull(userIPORegistrationDetails)){
            logger.error("Already subscribed for ipo : {}", ipoDetails.getName());
            throw new BadRequestException("Already subscribed for ipo : "+ipoDetails.getName());
        }


        if(ipoDetails.getExpiry().before(new Date())){
            logger.error("Ipo {} window expired. Cannot register", ipoDetails.getName());
            throw new BadRequestException("Ipo window expired. Cannot register for " + ipoDetails.getName());
        }


        if(!isValidCutOffPrice(userIPORegistrationDto.getCutOffPrice(), ipoDetails)){
            logger.error("Cut Off price not valid for ipo : {}", ipoDetails.getName());
            throw new BadRequestException("Cut Off price not valid for ipo : " +ipoDetails.getName());
        }


        userIPORegistrationDetails = new UserIPORegistrationDetails();
        userIPORegistrationDetails.setIpoId(ipoDetails.getId());
        userIPORegistrationDetails.setUserId(user.getId());
        userIPORegistrationDetails.setCutOffPrice(userIPORegistrationDto.getCutOffPrice());
        userIPORegistrationDetails.setLots(userIPORegistrationDto.getLotsApplied());
        userIPORegistrationDetailsRepository.save(userIPORegistrationDetails);


        return "Registered for IPO";
    }

    private boolean isValidCutOffPrice(BigInteger cutOffPrice, IPODetails ipoDetails){
        int lowerBandValue = cutOffPrice.compareTo(ipoDetails.getLowerBandPrice());
        int upperBandValue = cutOffPrice.compareTo(ipoDetails.getUpperBandPrice());
        return ((lowerBandValue == 0 || lowerBandValue == 1) && (upperBandValue == 0 || upperBandValue == -1));

    }
}
