package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;
import com.example.fruitdemo0306.repository.UserLoginDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserLoginServiceImpl implements UserLoginService{
@Resource
private UserLoginDAO userLoginDAO;

    @Override
    public User loginService(String name, String password) {
        User user = userLoginDAO.findByNameAndPassword(name,password);
        if(user != null){
            user.setPassword("");
        }

        return user;
    }


}
