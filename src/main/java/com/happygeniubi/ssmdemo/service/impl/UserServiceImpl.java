package com.happygeniubi.ssmdemo.service.impl;

import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.mapper.UserMapper;
import com.happygeniubi.ssmdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public static Map<String, User> tokenMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        User user = userMapper.login(username, password);
        if(user == null) {
            return null;
        }else {
            String token = UUID.randomUUID().toString();
            log.info("username:{},token:{}", username, token);
            tokenMap.put(token, user);
            return token;
        }
    }

    @Override
    public List<User> userList() {
        return userMapper.list();
    }
}
