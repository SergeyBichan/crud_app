package ru.myself.crud_app.dto;

import lombok.Data;
import ru.myself.crud_app.entity.Salary;

import java.math.BigDecimal;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private BigDecimal salary;
}
