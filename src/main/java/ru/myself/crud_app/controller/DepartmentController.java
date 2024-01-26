package ru.myself.crud_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.service.impl.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }


    @PostMapping("/departments")
    public ResponseEntity<Map<String, String>> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.save(departmentDto));
    }
}
