package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.User;
import org.springframework.stereotype.Service;

public interface UserLoginService {

    User loginService(String name, String password);
}
