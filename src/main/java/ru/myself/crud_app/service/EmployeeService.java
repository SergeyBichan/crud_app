package ru.myself.crud_app.service;

import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    Employee findById(Long id);
    Map<String, String> create(Employee employee);

}
