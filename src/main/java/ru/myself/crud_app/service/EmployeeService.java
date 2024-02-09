package ru.myself.crud_app.service;

import ru.myself.crud_app.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto findById(Long id);
    Map<String, String> create(EmployeeDto employee);
    Map<String, String> update(EmployeeDto employee);

}
