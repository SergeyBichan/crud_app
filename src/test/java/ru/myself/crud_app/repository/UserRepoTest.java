package ru.myself.crud_app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.myself.crud_app.entity.User;

import java.util.List;

@SpringBootTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;


    @Test
    public void printInfoAboutAllUsers() {
        List<User> userList = userRepo.findAll();
        System.out.println(userList);
    }
}