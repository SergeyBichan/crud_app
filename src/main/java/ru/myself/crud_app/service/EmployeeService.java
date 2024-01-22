package ru.myself.crud_app.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.EmployeeDto;
import ru.myself.crud_app.entity.Employee;
import ru.myself.crud_app.exception.ResourceNotFoundException;
import ru.myself.crud_app.repository.EmployeeRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;


    public List<EmployeeDto> getAllEmployees() {
        try {
            return convertedToDto(employeeRepo.findAll());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Employees not found!");
        }
    }


    public List<EmployeeDto> getEmployeesByDepartment(Integer depId) {
        try {
            return
                    convertedToDto(employeeRepo.findEmployeesByDepartment_Id(depId));
        } catch (Exception e) {
            throw new ResourceNotFoundException(
                    "Department with id:" + depId + " not found!"
            );
        }
    }


    private List<EmployeeDto> convertedToDto(List<Employee> employees) {
        return employees
                .stream()
                .map(data -> modelMapper.map(data, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
