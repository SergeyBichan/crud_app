package ru.myself.crud_app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.myself.crud_app.entity.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Test
    public void findAllEmployes() {
        List<Employee> all = employeeRepo.findAll();
        System.out.println(all);
    }


}