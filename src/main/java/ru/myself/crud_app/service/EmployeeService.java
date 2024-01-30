package ru.myself.crud_app.service;

import org.springframework.stereotype.Service;
import ru.myself.crud_app.entity.Employee;

import java.util.Map;

public interface EmployeeService {
    Iterable<Employee> getAllEmployees();
    Employee findById(Long id);
    Map<String, String> create(Employee employee);

}
