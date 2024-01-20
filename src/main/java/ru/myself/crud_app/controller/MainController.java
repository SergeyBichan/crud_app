package ru.myself.crud_app.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.myself.crud_app.dto.UserDto;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.entity.Salary;
import ru.myself.crud_app.entity.User;
import ru.myself.crud_app.repository.DepartmentRepo;
import ru.myself.crud_app.repository.SalaryRepo;
import ru.myself.crud_app.repository.UserRepo;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final SalaryRepo salaryRepo;
    private final UserRepo userRepo;
    private final DepartmentRepo departmentRepo;
    private final ModelMapper mapper;

//    @GetMapping("/{id}")
//    public UserDto getUserWithSalaryById(@PathVariable Long id) {
//
//        Salary salary = salaryRepo.findByUserId(id);
//
//        User user = salary.getUser();
//        UserDto userDto = convertToDto(user);
//        userDto.setSalary(salary.getSum());
//
//        return userDto;
//    }

    @GetMapping("/")
    public List<UserDto> findAllUsers() {
        List<User> allUsers = userRepo.findAll();
        List<UserDto> allUsersDto = allUsers.stream().map(this::convertToDto).toList();
        return allUsersDto;
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = mapper.map(user,UserDto.class);
        return userDto;
    }

    @GetMapping("/dep")
    public List<Department> getAllDeps() {
        return departmentRepo.findAll();
    }


}
