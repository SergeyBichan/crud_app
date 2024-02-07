package ru.myself.crud_app.dto;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentDto {
    private Long id;
    private String name;
    private List<EmployeeDto> employeesDto;
}
