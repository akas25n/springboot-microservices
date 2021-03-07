package com.departmentservice.controller;

import com.departmentservice.entity.Department;
import com.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable long id){
        log.info("Inside getDepartmentById method of DepartmentController");
        return departmentService.findByDepartmentId(id);
    }
    @PostMapping
    public Department save(@RequestBody Department department){
        log.info("Inside save department method of DepartmentController");
        return departmentService.save(department);
    }
}
