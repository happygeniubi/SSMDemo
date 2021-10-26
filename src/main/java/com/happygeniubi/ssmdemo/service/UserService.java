package com.happygeniubi.ssmdemo.service;

import com.happygeniubi.ssmdemo.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String password);

    List<User> userList();
}
