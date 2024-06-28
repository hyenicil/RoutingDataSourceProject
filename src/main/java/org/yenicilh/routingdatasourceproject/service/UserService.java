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

    public List<UserEntity> getUsers(String city) {
        if(city.equalsIgnoreCase("kilis")) {
            ClientDatabaseContextHolder.set(ClientDatabase.DB_1);
        }
        if (city.equalsIgnoreCase("antep")) {
            ClientDatabaseContextHolder.set(ClientDatabase.DB_2);
        }

        return userRepository.findAll();
    }
}


