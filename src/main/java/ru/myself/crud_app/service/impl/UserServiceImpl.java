package ru.myself.crud_app.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.myself.crud_app.dto.UserDto;
import ru.myself.crud_app.entity.Salary;
import ru.myself.crud_app.entity.User;
import ru.myself.crud_app.entity.temp.UserDepartment;
import ru.myself.crud_app.repository.SalaryRepo;
import ru.myself.crud_app.repository.UserDepartmentRepo;
import ru.myself.crud_app.repository.UserRepo;
import ru.myself.crud_app.service.UserService;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private SalaryRepo salaryRepo;
    private UserDepartmentRepo userDepartmentRepo;
    private ModelMapper modelMapper;
    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> allUsersDto = userRepo.findAll().stream().map(this::convertToDto).toList();
        return allUsersDto;
    }



    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user,UserDto.class);
//        Salary salary = salaryRepo.findSalaryByUserId(user.getId());
//        userDto.setSalary(salary);
        return userDto;
    }
}
