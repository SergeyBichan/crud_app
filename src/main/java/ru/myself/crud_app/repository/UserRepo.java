package ru.myself.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myself.crud_app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
