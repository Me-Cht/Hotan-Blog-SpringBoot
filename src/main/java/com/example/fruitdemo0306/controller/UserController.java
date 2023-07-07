package com.example.fruitdemo0306.controller;

/**
 * @Author Hotan
 * @Date 2023/3/12 20:29
 * @PackageName:com.example.fruitdemo0306.controller
 * @ClassName: UserController
 * @Description: TODO
 * @Version 1.0
 */

import com.example.fruitdemo0306.Service.UserLoginService;
import com.example.fruitdemo0306.Service.UserService;
import com.example.fruitdemo0306.bean.User;
import com.example.fruitdemo0306.utils.JwtUtils;
import com.example.fruitdemo0306.utils.Result;
import com.example.fruitdemo0306.utils.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserLoginService userLoginService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/getAllData")
    public List<User> getAllData(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        User registeredUser = userService.registerService(user);
        if (registeredUser != null) {
            userRepository.save(registeredUser);
            return Result.success(user,"注册成功！");
        } else {
            // 返回注册失败的响应，可以根据需要进行自定义
            return Result.error("10000","该用户名已存在！");
        }
    }

    //用户登陆接口
    @RequestMapping("/login")
    public Result login(@RequestBody User user){
        String name = user.getName();
        String password = user.getPassword();
        User login = userLoginService.loginService(name,password);
        String token = JwtUtils.generateToken(name);
        if(login != null){
            return Result.success(token,"登陆成功！");
        }
        else {
            return Result.error("10000","密码错误！");
        }
    }

    //获取用户信息
    @GetMapping("/info")
    public Result info(String token) throws JsonProcessingException {
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        User user = userService.detailInfo(username);
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        return Result.success("name",userJson);
    }

    @GetMapping("/logout")
    public Result logout(){
        return Result.ok();
    }




}