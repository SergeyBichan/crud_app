package ru.myself.crud_app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.entity.Salary;
import ru.myself.crud_app.entity.Sector;

@Data
@RequiredArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String first_name;
    private String last_name;
    private int age;
    private Department department;
    private Sector sector;
    private Salary salary;
}
