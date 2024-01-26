package ru.myself.crud_app.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @NonNull
    private String name;
}
