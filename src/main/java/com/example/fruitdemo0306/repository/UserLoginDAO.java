package com.example.fruitdemo0306.repository;

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDAO extends JpaRepository<User,Long> {


    User findByNameAndPassword(String name, String password);
}
