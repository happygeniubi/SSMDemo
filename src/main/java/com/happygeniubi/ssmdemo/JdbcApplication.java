package com.happygeniubi.ssmdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApplication {

    public static void main(String[] args) throws Exception {
        /*
         * 原生jdbc访问数据库步骤
         * 加载JDBC驱动程序
         * 创建数据库的连接
         * 创建preparedStatement
         * 执⾏SQL语句
         * 处理结果集
         * 关闭JDBC对象资源
         */
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接
        String url = "jdbc:mysql://127.0.0.1:3306/hpclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";

        String username = "root";
        String password = "hzl26918826";

        //获取连接对象，并连接数据库
        Connection connection = DriverManager.getConnection(url,username,password);
        //获取语句对象
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from video");
        while (resultSet.next()){
            System.out.println("视频标 题:"+resultSet.getString("title"));
        }
        statement.close();
    }
}
