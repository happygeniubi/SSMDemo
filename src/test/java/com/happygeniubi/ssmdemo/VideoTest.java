package com.happygeniubi.ssmdemo;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class) // 使用底层junit SpringJunit4ClassRunner
@SpringBootTest(classes = {SSMDemoApplication.class}) // 启动整个SpringBoot工程
@AutoConfigureMockMvc
public class VideoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoList() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        //会乱码
        //String result = mvcResult.getResponse().getContentAsString();
        // 使用下面这个，增加编码说明，就不会乱码打印
        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        System.out.println(result);
    }

    @Before
    public void before() {
        System.out.println("测试Before");
    }

    @Test
    public void test() {
        System.out.println("测试Test");
        TestCase.assertEquals(1,1);
    }

    @After
    public void after() {
        System.out.println("测试After");
    }
}
