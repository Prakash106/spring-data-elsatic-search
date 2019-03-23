package com.programmingarea.springdataelasticserach.resource;

import com.programmingarea.springdataelasticserach.model.User;
import com.programmingarea.springdataelasticserach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> usersList = userRepository.findAll();
        for (User user: usersList) {
            users.add(user);
        }
        return users;
    }

    @GetMapping("users/name/{name}")
    public List<User> findByName(@PathVariable final String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("users/salary/{salary}")
    public List<User> findBySalary(@PathVariable final String salary) {
        return userRepository.findBySalary(salary);
    }

    @GetMapping("users/salary/range/{salary}")
    public List<User> findBySalaryGreaterThan(@PathVariable final String salary) {
        return userRepository.findAllBySalaryGreaterThan(salary);
    }

    @GetMapping("users/index/delete")
    public boolean deleteIndex() {
        return elasticsearchTemplate.deleteIndex(User.class);
    }
    
}
