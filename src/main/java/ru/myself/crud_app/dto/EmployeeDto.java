package ru.myself.crud_app.dto;

import lombok.Data;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.entity.Salary;

@Data
public class EmployeeDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Department department;
    private Salary salary;
}
