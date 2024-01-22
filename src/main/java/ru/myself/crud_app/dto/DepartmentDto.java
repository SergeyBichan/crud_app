package ru.myself.crud_app.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class DepartmentDto {
    private Long id;
    @NonNull
    private String name;


}
