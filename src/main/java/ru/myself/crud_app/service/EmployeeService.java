package ru.myself.crud_app.service;

import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    List<EmployeeDto> getEmployeesByDepartment(Integer depId);
    EmployeeDto getEmployeeById(Integer id);
    Map<String, String> save(EmployeeDto employeeDto);
}
