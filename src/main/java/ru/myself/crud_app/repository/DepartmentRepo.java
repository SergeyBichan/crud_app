package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myself.crud_app.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Department findByName(String name);
}
