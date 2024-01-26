package ru.myself.crud_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
}
