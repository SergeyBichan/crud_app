package ru.myself.crud_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.repository.DepartmentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepo departmentRepo;


    public List<Department> getAll() {
        return departmentRepo.findAll();
    }
}
