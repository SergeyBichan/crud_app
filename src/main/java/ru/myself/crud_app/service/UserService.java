package ru.myself.crud_app.service;

import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.UserDto;
import ru.myself.crud_app.entity.User;

import java.util.List;



public interface UserService {
    List<UserDto> findAllUsers();
}
