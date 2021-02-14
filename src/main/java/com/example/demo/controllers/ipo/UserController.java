package com.example.demo.controllers.ipo;

import com.example.demo.dto.UserDto;
import com.example.demo.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created By : arshia on 05/02/21
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Create New User")
    @PostMapping(value = "")
    public String createNewUser(@RequestBody UserDto userDto) {
        return userService.createNewUser(userDto);
    }
}
