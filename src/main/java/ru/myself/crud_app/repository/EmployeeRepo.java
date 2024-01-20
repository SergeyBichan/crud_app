package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myself.crud_app.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
