package ru.myself.crud_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "departments")
//@ToString(exclude = "user")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "id"
//    )
//    private User user;
//
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//            name = "department_id",
//            referencedColumnName = "id"
//    )
//    private List<User> users;
}
