package ru.myself.crud_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/")
    public List<EmployeeDto> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/byDepId/{id}")
    public List<EmployeeDto> getEmployeesByDepartmentId(@PathVariable("id") Integer id) {
        return employeeService.getEmployeesByDepartment(id);
    }



}
