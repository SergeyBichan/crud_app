package ru.myself.crud_app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.repository.DepartmentRepo;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepo departmentRepo;
    public final ModelMapper modelMapper;


    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "name cant be empty")
    @Transactional
    public void save(DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment =
                Optional.ofNullable(departmentRepo.findByName(departmentDto.getName()));
        if (optionalDepartment.isEmpty()) {
            Department departmentToSave = modelMapper.map(departmentDto, Department.class);
            departmentRepo.save(departmentToSave);
            log.info(departmentToSave.getName());
        } else {
            throw new RuntimeException("Department with name: " + departmentDto.getName() + " was found!");
        }
    }
}
