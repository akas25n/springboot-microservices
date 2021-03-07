package com.userservice.service;

import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import com.userservice.valueObject.Department;
import com.userservice.valueObject.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    public UserService(UserRepository userRepository, ResponseTemplate responseTemplate, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartmentByUserId(long userId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
                        Department.class);

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);

        return responseTemplate;
    }
}
