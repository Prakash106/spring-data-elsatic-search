package com.programmingarea.springdataelasticserach.resource;

import com.programmingarea.springdataelasticserach.model.User;
import com.programmingarea.springdataelasticserach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> usersList = userRepository.findAll();
        for (User user: usersList) {
            users.add(user);
        }
        return users;
    }

    @GetMapping("user/name/{text}")
    public List<User> findByName(@PathVariable final String text) {
        return userRepository.findByName(text);
    }

    @GetMapping("user/salary/{salary}")
    public List<User> findBySalary(@PathVariable final String salary) {
        return userRepository.findBySalary(salary);
    }

    @GetMapping("user/salary/range/{salary}")
    public List<User> findBySalaryGreaterThan(@PathVariable final String salary) {
        return userRepository.findAllBySalaryGreaterThan(salary);
    }
    
}
