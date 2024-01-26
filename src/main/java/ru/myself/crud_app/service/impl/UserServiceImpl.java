package ru.myself.crud_app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.dto.UserDto;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.entity.User;
import ru.myself.crud_app.repository.UserRepo;
import ru.myself.crud_app.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    @Override
    public List<UserDto> getAllUsers() {
        return convertedToDto(
                userRepo.findAll()
        );
    }

    private UserDto convertedToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private List<UserDto> convertedToDto(List<User> users) {
        return users
                .stream()
                .map(data -> modelMapper.map(data, UserDto.class))
                .collect(Collectors.toList());
    }
}
