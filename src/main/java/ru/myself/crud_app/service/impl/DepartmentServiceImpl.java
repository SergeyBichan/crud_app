package ru.myself.crud_app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.myself.crud_app.dto.DepartmentDto;
import ru.myself.crud_app.entity.Department;
import ru.myself.crud_app.exception.ResourceIsFoundException;
import ru.myself.crud_app.exception.ResourceNotFoundException;
import ru.myself.crud_app.repository.DepartmentRepo;
import ru.myself.crud_app.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    public final ModelMapper modelMapper;

    public List<DepartmentDto> getAllDepartments() {
        //Так лучше ведь? только вот может ли быть ситуация, когда департаментов нет? я должен это предусмотреть?
//        return departmentRepo.findAll()
//                .stream()
//                .map(data -> modelMapper.map(data, DepartmentDto.class))
//                .collect(Collectors.toList());
        return convertedToDto(departmentRepo.findAll());

    }

    public DepartmentDto getDepartmentById(Integer id) {
        return convertedToDto(departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department with id:" + id + " not found!")));
    }

//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "name can't be empty")
//    @Transactional
//    public void save(DepartmentDto departmentDto) {
//        Optional<Department> optionalDepartment =
//                Optional.ofNullable(departmentRepo.findByName(departmentDto.getName()));
//        if (optionalDepartment.isEmpty()) {
//            Department departmentToSave = modelMapper.map(departmentDto, Department.class);
//            departmentRepo.save(departmentToSave);
//            log.info(departmentToSave.getName());
//        } else {
//            throw new ResourceIsFoundException("Department with name: " + departmentDto.getName() + " is exist!");
//        }
//    }

    @Override
    public Map<String, String> save(DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment =
                Optional.ofNullable(departmentRepo.findByName(departmentDto.getName()));
        if (optionalDepartment.isEmpty()) {
            Department departmentToSave = modelMapper.map(departmentDto, Department.class);
            departmentRepo.save(departmentToSave);
            log.info(departmentToSave.getName());
        } else {
            throw new RuntimeException("Department with name: " + departmentDto.getName() + " was found!");
        }
        System.out.println(Map.of("message", "Department was saved!"));
        return Map.of("message", "Department was saved!");
    }

    private DepartmentDto convertedToDto(Department department) {
        return modelMapper.map(department, DepartmentDto.class);
    }

    private List<DepartmentDto> convertedToDto(List<Department> departments) {
        return departments
                .stream()
                .map(data -> modelMapper.map(data, DepartmentDto.class))
                .collect(Collectors.toList());
    }
}
