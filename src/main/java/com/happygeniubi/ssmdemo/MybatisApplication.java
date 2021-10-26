package com.happygeniubi.ssmdemo;

import com.happygeniubi.ssmdemo.dao.VideoMapper;
import com.happygeniubi.ssmdemo.dao.VideoOrderMapper;
import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.domain.Video;
import com.happygeniubi.ssmdemo.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisApplication {
    public static void main(String [] args) throws IOException {

        String resouce = "config/mybatis-config.xml";

        //读取配置文件
        InputStream inputStream =  Resources.getResourceAsStream(resouce);

        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取Session
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            VideoOrderMapper videoOrderMapper = sqlSession.getMapper(VideoOrderMapper.class);

            Video video = videoMapper.selectById(44);
            System.out.println(video.toString());

            List<VideoOrder> videoOrders = videoOrderMapper.queryVideoOrderList();
            System.out.println(videoOrders.get(0));

            List<User> users = videoOrderMapper.queryUserOrderList();
            System.out.println(users.get(0));


            //通过注解
            //List<Video> videoList =  videoMapper.selectList();


//            List<Video> videoList = videoMapper.selectListByXML();

//            System.out.println(videoList.toString());
        }

    }
}
