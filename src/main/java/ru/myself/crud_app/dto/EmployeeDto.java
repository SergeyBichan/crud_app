package ru.myself.crud_app.dto;

import lombok.Data;
import ru.myself.crud_app.entity.Salary;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Salary salary;
    private DepartmentDtoWithoutEmployees departmentDto;
}
