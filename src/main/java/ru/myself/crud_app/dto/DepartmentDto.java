package ru.myself.crud_app.dto;

import jakarta.persistence.OneToMany;
import ru.myself.crud_app.entity.Employee;

import java.util.Set;

public class DepartmentDto {
    private Long id;
    private String name;
    @OneToMany
    private Set<Employee> employees;
}
