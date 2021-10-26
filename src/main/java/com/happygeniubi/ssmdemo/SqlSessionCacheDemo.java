package com.happygeniubi.ssmdemo;


import com.happygeniubi.ssmdemo.dao.VideoOrderMapper;
import com.happygeniubi.ssmdemo.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionCacheDemo {

    public static void main(String[] args) throws IOException {

        String resouce = "config/mybatis-config.xml";

        //读取配置文件
        InputStream inputStream =  Resources.getResourceAsStream(resouce);

        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try {
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            VideoMapper videoMapper =  sqlSession.getMapper(VideoMapper.class);
//            Video video = videoMapper.selectById(44);
//            System.out.println(video);
//            sqlSession.commit();
//
//            SqlSession sqlSession2 = sqlSessionFactory.openSession();
//            VideoMapper videoMapper2 =  sqlSession.getMapper(VideoMapper.class);
//            Video video2 = videoMapper.selectById(44);
//            System.out.println(video2);
//            sqlSession.commit();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            VideoOrderMapper videoOrderMapper =  sqlSession.getMapper(VideoOrderMapper.class);
            List<VideoOrder> videoOrders = videoOrderMapper.queryVideoOrderListLazy();
            for (VideoOrder videoOrder : videoOrders) {
//                System.out.println(videoOrder.getVideoTitle());
                System.out.println(videoOrder.getUser().getUsername());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
