package com.parkingspacesapp.ParkingSpaces.controllers;

import com.parkingspacesapp.ParkingSpaces.common.dto.UserDto;
import com.parkingspacesapp.ParkingSpaces.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/findById", method = RequestMethod.GET)
    public UserDto getUserById(@RequestParam Long id) {
        return userService.findUserById(id);
    }
}
