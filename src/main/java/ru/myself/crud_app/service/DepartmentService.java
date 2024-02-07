package ru.myself.crud_app.service;

import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAllDepartments();
}
