package ru.myself.crud_app.service;

import ru.myself.crud_app.dto.DepartmentDto;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(Integer id);

//    void save(DepartmentDto departmentDto);

    Map<String, String> save(DepartmentDto departmentDto);

}
