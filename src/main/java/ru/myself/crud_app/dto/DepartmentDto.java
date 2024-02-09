package ru.myself.crud_app.dto;

import lombok.*;

import java.util.List;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private List<EmployeeDtoWithoutDepartment> employeesDto;
}
