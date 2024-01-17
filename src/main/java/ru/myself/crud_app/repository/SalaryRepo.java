package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.myself.crud_app.entity.Salary;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long> {
    @Query(value = "select s from salaries AS s where user_id=?1", nativeQuery = true)
    Salary findSalaryByUserId(@Param("user_id") Long user_id);
}
