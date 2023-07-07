package com.example.fruitdemo0306.Service;

import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.bean.UserLogin;
import com.example.fruitdemo0306.repository.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDAO userDAO;
    @Override
    public User registerService(User user) {
        boolean userExists = userDAO.existsByName(user.getName());
        if(userExists){
            return null;
        }else {
            return userDAO.save(user);
        }
    }

    @Override
    public User detailInfo(String username) {
        return userDAO.findByName(username);
    }


}
