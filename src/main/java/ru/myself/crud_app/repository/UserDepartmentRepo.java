package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myself.crud_app.entity.temp.UserDepartment;

public interface UserDepartmentRepo extends JpaRepository<UserDepartment, Long> {
}
