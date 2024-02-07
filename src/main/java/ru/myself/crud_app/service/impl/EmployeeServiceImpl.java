package ru.myself.crud_app.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.entity.Department;
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
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            EmployeeDto employeeDto = new EmployeeDto();

            Long id = employeeList.get(i).getEmployeeId();
            String fName = employeeList.get(i).getFirstName();
            String lName = employeeList.get(i).getLastName();
            int age = employeeList.get(i).getAge();
            DepartmentDto department = modelMapper
                    .map(employeeList.get(i).getDepartment(), DepartmentDto.class);

            employeeDto.setId(id);
            employeeDto.setFirstName(fName);
            employeeDto.setLastName(lName);
            employeeDto.setAge(age);
            employeeDto.setDepartmentDto(department);

            employeeDtoList.add(employeeDto);
        }

        return employeeDtoList;
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
