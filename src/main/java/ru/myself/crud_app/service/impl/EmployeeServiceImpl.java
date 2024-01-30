package ru.myself.crud_app.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.entity.Employee;
import ru.myself.crud_app.exception.ResourceIsFoundException;
import ru.myself.crud_app.exception.ResourceNotFoundException;
import ru.myself.crud_app.repository.EmployeeRepo;
import ru.myself.crud_app.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found employee by id:" + id)
        );
    }
    @Transactional
    @Override
    public Map<String, String> create(Employee employee) {
        Optional<Employee> _employee = employeeRepo.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());

        if (_employee.isPresent()){
            throw new ResourceIsFoundException(
                    "Employee with first name:" + employee.getFirstName() +
                            " and last name:" + employee.getLastName() + " already exist!");
        }
        employeeRepo.save(employee);
        return Map.of("message", "employee successfully saved!");
    }


}
