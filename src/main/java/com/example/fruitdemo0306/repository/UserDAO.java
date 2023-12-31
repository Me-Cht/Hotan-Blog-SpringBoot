package com.example.fruitdemo0306.repository;

import com.example.fruitdemo0306.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByName(String name);
    boolean existsByName(String name);


}
