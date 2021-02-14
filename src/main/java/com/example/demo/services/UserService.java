package com.example.demo.services;

import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.runtimeExceptions.BadRequestException;
import com.example.demo.models.User;
import com.example.demo.repository.UserIPORegistrationDetailsRepository;
import com.example.demo.repository.UserRepository;
import javassist.tools.web.BadHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created By : arshia on 05/02/21
 **/
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public String createNewUser(UserDto userDto){
        User user = userRepository.findByEmailOrContactNumber(userDto.getEmail(), userDto.getContactNumber());

        if(Objects.nonNull(user)){
            logger.error("User with contact number : {} already present. Try again!", userDto.getContactNumber());
            throw new BadRequestException("User with contact number : "+userDto.getContactNumber()+" already present. Try again!");
        }

        user = new User();
        user.setContactNumber(userDto.getContactNumber());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        userRepository.save(user);
        return "New user created!";
    }

    public User getUser(String contactNumber){
        User user = userRepository.findByContactNumber(contactNumber);

        if(Objects.isNull(user)){
            logger.error("User with contact number : {} not present. Try again!", contactNumber);
            throw new BadRequestException("User with contact number : "+contactNumber+" not present. Try again!");
        }

        return user;
    }



}
