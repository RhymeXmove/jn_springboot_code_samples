package org.javaboy.mybatis.controller;

import org.javaboy.mybatis.bean.User;
import org.javaboy.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/getalluser")
    @ResponseBody
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    @GetMapping("/getuserbyid")
    @ResponseBody
    public List<User> getUserById(User user){
       return userMapper.getUserById(user.getId());
    }

    @GetMapping("/getuserbyname")
    @ResponseBody
    public List<User> getUserByName(User user){
        return userMapper.getUserByName(user.getUsername());
    }

    @GetMapping("/adduser")
    @ResponseBody
    public Integer addUser(User user){
        return userMapper.addUser(user);
    }

    @GetMapping("/updateuserbyid")
    @ResponseBody
    public Integer updateUserById(User user){
        return userMapper.updateUserById(user);
    }

    @GetMapping("/deleteuserbyid")
    @ResponseBody
    public Integer deleteUserById(User user){
        Integer a = Math.toIntExact(user.getId());
        return userMapper.deleteUserById(a);
    }

}
