package com.programmingarea.springdataelasticserach.load;

import com.programmingarea.springdataelasticserach.model.User;
import com.programmingarea.springdataelasticserach.jpaRepository.UserJpaRepository;
import com.programmingarea.springdataelasticserach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class loader {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @PostConstruct
    @Transactional
    public void loadAllUsers() {
        operations.putMapping(User.class);
        List<User> users = new ArrayList<>();

        System.out.println("Loading Data to H2Database");
        users = userJpaRepository.saveAll(getData());
        System.out.println("Loading Completed !");

        System.out.println("Loading Data to elastic search");
        userRepository.saveAll(users);
        System.out.println("Loading Completed !");
    }

    private List<User> getData() {
        List<User> users = new ArrayList<>();;
        users.add(new User(11L,"Paras", "Developer", "1212"));
        users.add(new User(12L,"Arun", "DevOps", "121200"));
        users.add(new User(13L,"Akbar", "Tester", "100000"));
        users.add(new User(14L,"Surya", "Designer", "123000000"));
        users.add(new User(15L,"Lohit", "Debugger", "100000"));
        return users;
    }
}
