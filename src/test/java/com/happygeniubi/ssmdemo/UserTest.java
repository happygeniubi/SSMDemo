package com.happygeniubi.ssmdemo;

import com.happygeniubi.ssmdemo.controller.UserController;
import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.utils.JsonData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 使用底层junit SpringJunit4ClassRunner
@SpringBootTest(classes = {SSMDemoApplication.class}) // 启动整个SpringBoot工程
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest() {
        User user = new User();
        user.setPassword("Text1");
        user.setUsername("happygeniubi");
        JsonData jsonData = userController.login(user);
        System.out.println(jsonData.toString());
        TestCase.assertEquals(200, jsonData.getCode());
    }
}
