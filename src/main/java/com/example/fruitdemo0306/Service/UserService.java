package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;

public interface UserService {


    User registerService(User user);
    User detailInfo(String username);


}
