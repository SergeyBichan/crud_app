package ru.myself.crud_app.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.DepartmentDtoWithoutEmployees;
import ru.myself.crud_app.dto.EmployeeDto;
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
            DepartmentDtoWithoutEmployees department = modelMapper
                    .map(employeeList.get(i).getDepartment(), DepartmentDtoWithoutEmployees.class);

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
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found employee by id:" + id)
        );
        EmployeeDto dto = new EmployeeDto();

        dto.setId(employee.getEmployeeId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setAge(employee.getAge());
        dto.setSalary(employee.getSalary());
        dto.setDepartmentDto(modelMapper.map(employee.getDepartment(), DepartmentDtoWithoutEmployees.class));

        return dto;
    }
    @Transactional
    @Override
    public Map<String, String> create(EmployeeDto employee) {
        Optional<Employee> _employee = employeeRepo.findByFirstNameAndLastName(
                employee.getFirstName(), employee.getLastName()
        );

        if (_employee.isPresent()){
            throw new ResourceIsFoundException(
                    "Employee with first name:" + employee.getFirstName() +
                            " and last name:" + employee.getLastName() + " already exist!");
        }

        Employee employeeToSave = modelMapper.map(employee, Employee.class);
        employeeRepo.save(employeeToSave);
        return Map.of("message", "employee successfully saved!");
    }

    @Override
    public Map<String, String> update(EmployeeDto employee) {
        return null;
    }


}
