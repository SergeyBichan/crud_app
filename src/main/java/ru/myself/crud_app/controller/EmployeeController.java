package ru.myself.crud_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;


    @GetMapping(value = "/employees")
    public List<EmployeeDto> getAll() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping(value = "/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Integer id) {
        return employeeServiceImpl.getEmployeeById(id);
    }

    @GetMapping("/byDepId/{id}")
    public List<EmployeeDto> getEmployeesByDepartmentId(@PathVariable("id") Integer id) {
        return employeeServiceImpl.getEmployeesByDepartment(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Map<String, String>> saveEmployeeToDB(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeServiceImpl.save(employeeDto));
    }





}
