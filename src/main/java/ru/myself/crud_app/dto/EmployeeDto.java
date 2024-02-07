package ru.myself.crud_app.dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private DepartmentDto departmentDto;
}
