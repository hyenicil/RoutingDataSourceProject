package org.yenicilh.routingdatasourceproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static org.yenicilh.routingdatasourceproject.constant.EntityConstants.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = USERENTITY)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Integer id;

    @Column(name = USERNAME)
    private String username;

    @Column(name = CITY_NAME)
    private String cityName;
}
