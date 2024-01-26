package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myself.crud_app.entity.Employee;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByDepartment_Id(Integer id);
    Optional<Employee> findEmployeeById(Integer id);
    Employee findEmployeeByFirstname(String firstName);
    Employee findEmployeeByLastname(String lastName);
    Employee findEmployeeByFirstnameAndLastname(String firstName, String lastName);

}
