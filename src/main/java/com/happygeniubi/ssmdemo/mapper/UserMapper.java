package com.happygeniubi.ssmdemo.mapper;

import com.happygeniubi.ssmdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {
    private static Map<String, User> userMap = new HashMap<>();

    static {
//        userMap.put("happygeniubi", new User(1, "happygeniubi", "Text1"));
//        userMap.put("jack", new User(2, "jack", "Text2"));
//        userMap.put("lucky", new User(3, "lucky", "Text3"));
    }

    public User login(String username, String password) {
        // 帐号密码校验逻辑...
        User user = userMap.get(username);
        if(!password.equals(user.getPassword())) {
            return null;
        }
        return userMap.get(username);
    }

    public List<User> list() {
        List<User> userList = new ArrayList<>();
        userList.addAll(userMap.values());
        return userList;
    }
}
