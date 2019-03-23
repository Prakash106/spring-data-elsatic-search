package com.programmingarea.springdataelasticserach.repository;

import com.programmingarea.springdataelasticserach.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

    public List<User> findByName(String name);

    List<User> findBySalary(String salary);

    List<User> findAllBySalaryGreaterThan(String salary);
}
