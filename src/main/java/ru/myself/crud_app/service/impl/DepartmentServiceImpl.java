package ru.myself.crud_app.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.dto.EmployeeDtoWithoutDepartment;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.exception.ResourceNotFoundException;
import ru.myself.crud_app.repository.DepartmentRepo;
import ru.myself.crud_app.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepo.findAll();

        List<DepartmentDto> departmentDtos = new ArrayList<>();

        for (int i = 0; i < departments.size(); i++) {
            DepartmentDto tempDepartmentDto = new DepartmentDto();

            Long id = departments.get(i).getDepartmentId();
            String name = departments.get(i).getName();
            List<EmployeeDtoWithoutDepartment> employeeDtosWithoutDepartment = departments.get(i)
                    .getEmployees()
                    .stream()
                    .map((element) -> modelMapper.map(element, EmployeeDtoWithoutDepartment.class))
                    .toList();

            tempDepartmentDto.setId(id);
            tempDepartmentDto.setName(name);
            tempDepartmentDto.setEmployeesDto(employeeDtosWithoutDepartment);

            departmentDtos.add(tempDepartmentDto);
        }

        return departmentDtos;

    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Department with id:" + id + " not found!")
        );

        return modelMapper.map(department, DepartmentDto.class);
    }
}
