package ru.myself.crud_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Map<String, String>> createEmployee(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<>
                (employeeService.create(employee), HttpStatus.CREATED);
    }
}
