package org.yenicilh.routingdatasourceproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yenicilh.routingdatasourceproject.config.ClientDatabase;
import org.yenicilh.routingdatasourceproject.config.ClientDatabaseContextHolder;
import org.yenicilh.routingdatasourceproject.repository.UserRepository;
import org.yenicilh.routingdatasourceproject.entity.UserEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<UserEntity> getUsers() {

        return userRepository.findAll();
    }
}


