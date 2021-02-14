package com.example.demo.controllers.ipo;

import com.example.demo.dto.UserIPORegistrationDto;
import com.example.demo.services.UserRegistrationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created By : arshia on 03/02/21
 **/
@RestController
@RequestMapping("/user/ipo/registration")
public class UserIPORegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @ApiOperation("Get User IPO Details By User Contact Number")
    @GetMapping(value = "/{contactNumber}")
    public List<UserIPORegistrationDto> getUserIPODetails(@PathVariable("contactNumber") String contactNumber) {
        return userRegistrationService.getUserIPORegistrationDetails(contactNumber);
    }

    @ApiOperation("Register For IPO")
    @PostMapping(value = "")
    public String registerUser(@RequestBody UserIPORegistrationDto userIPORegistrationDto) {
        return userRegistrationService.registerForIPO(userIPORegistrationDto);
    }
}
