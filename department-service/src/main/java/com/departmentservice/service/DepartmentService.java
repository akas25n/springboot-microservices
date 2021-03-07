package com.departmentservice.service;

import com.departmentservice.entity.Department;
import com.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        log.info("Inside save department method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Optional<Department> findByDepartmentId(long id) {
        log.info("Inside findByDepartmentId method of DepartmentService");
        return departmentRepository.findById(id);
    }
}
