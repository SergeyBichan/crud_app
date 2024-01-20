package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myself.crud_app.entity.Salary;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {
}
