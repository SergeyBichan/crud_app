package ru.myself.crud_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.myself.crud_app.dto.UserDto;
import ru.myself.crud_app.entity.Salary;
import ru.myself.crud_app.entity.temp.UserDepartment;
import ru.myself.crud_app.repository.SalaryRepo;
import ru.myself.crud_app.repository.UserDepartmentRepo;
import ru.myself.crud_app.service.UserService;

import java.util.List;

@AllArgsConstructor
@RestController

public class UserController {
    private UserService userService;
    private UserDepartmentRepo repo;
    private SalaryRepo salaryRepo;
    @GetMapping("/")
    public List<UserDto> findAll() {
        return userService.findAllUsers();
    }

    @GetMapping("/dep")
    public List<UserDepartment> findAllDepartments() {
        return repo.findAll();
    }

    @GetMapping("/salary")
    public List<Salary> findAllSalaries() {
        return salaryRepo.findAll();
    }

}
