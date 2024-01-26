package ru.myself.crud_app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.entity.Employee;
import ru.myself.crud_app.exception.ResourceNotFoundException;
import ru.myself.crud_app.repository.EmployeeRepo;
import ru.myself.crud_app.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;


    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        if (employeeList.isEmpty()) {
            throw new ResourceNotFoundException("Employees not found!");
        }
        return convertedToDto(employeeList);
    }


    public List<EmployeeDto> getEmployeesByDepartment(Integer depId) {
        List<Employee> employeeList = employeeRepo.findEmployeesByDepartment_Id(depId);
        if (employeeList.isEmpty()) {
            throw new ResourceNotFoundException("Department with id:" + depId + " not found!");
        }
        return convertedToDto(employeeList);
    }

    public EmployeeDto getEmployeeById(Integer id) {
        return convertedToDto(
                employeeRepo.findEmployeeById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " not found!"))
        );
    }


    @Override
    public Map<String, String> save(EmployeeDto employeeDto) {
        Optional<Employee> employee =
                Optional.ofNullable(employeeRepo.findEmployeeByFirstnameAndLastname(
                        employeeDto.getFirstname(), employeeDto.getLastname())
                );
        if (employee.isEmpty()) {
            Employee employeeToSave = modelMapper.map(employeeDto, Employee.class);
            employeeRepo.save(employeeToSave);
            log.info(employeeToSave.getFirstname(), employeeDto.getLastname());
        } else {
            throw new RuntimeException(
                    "Employee with name: " + employeeDto.getFirstname() +
                            " " + employeeDto.getLastname() + " was found!"
            );
        }
        return Map.of("message", "Employee was saved!");
    }


    private List<EmployeeDto> convertedToDto(List<Employee> employees) {
        return employees
                .stream()
                .map(data -> modelMapper.map(data, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    private EmployeeDto convertedToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
