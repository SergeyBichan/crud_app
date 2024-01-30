package ru.myself.crud_app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.repository.DepartmentRepo;
import ru.myself.crud_app.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
