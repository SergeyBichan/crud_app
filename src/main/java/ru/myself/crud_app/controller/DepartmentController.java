package ru.myself.crud_app.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartments(){
        return departmentService.getAllDepartments()
                .stream()
                .map(data -> modelMapper.map(data, DepartmentDto.class))
                .collect(Collectors.toList());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/departments")
    public void saveDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.save(departmentDto);
    }
}
