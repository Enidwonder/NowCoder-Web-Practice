package com.wsj.mvnWebPractice.service;

import com.wsj.mvnWebPractice.dao.UserMapper;
import com.wsj.mvnWebPractice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
