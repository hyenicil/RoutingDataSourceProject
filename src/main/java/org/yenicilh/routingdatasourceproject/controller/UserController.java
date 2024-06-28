package org.yenicilh.routingdatasourceproject.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yenicilh.routingdatasourceproject.entity.UserEntity;
import org.yenicilh.routingdatasourceproject.service.UserService;

import java.util.List;

import static org.yenicilh.routingdatasourceproject.constant.ControllerPathConstants.API_V1_USERS;
import static org.yenicilh.routingdatasourceproject.constant.ControllerPathConstants.CITY;

@RestController
@RequestMapping(API_V1_USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "intern")
    public List<UserEntity> getUsers(){
        return userService.getUsers();
    }
}
