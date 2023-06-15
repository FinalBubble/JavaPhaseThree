package org.finalBubble;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConn() throws SQLException{
        //// 1. 获取数据库连接
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
        //        "root", "root");
        //return conn;
        //优化 1
        //创建连接池对象
        //DruidDataSource druidDataSource = new DruidDataSource();
        //设置数据库连接信息
        //druidDataSource.setUrl("jdbc:mysql://localhost:3307/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        //druidDataSource.setUsername("root");
        //druidDataSource.setPassword("root");
        //设置初始连接数量
        druidDataSource.setInitialSize(3);
        //设置最大的连接数量
        druidDataSource.setMaxActive(5);
        //从连接池获取连接
        return druidDataSource.getConnection();
    }
    //优化2
    private static DruidDataSource druidDataSource;
    static { //只在类加载的时候运行一次,作用:用于初始化
        druidDataSource = new DruidDataSource();
        //设置数据库连接信息
        druidDataSource.setUrl("jdbc:mysql://localhost:3307/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        //设置初始连接数量
        //druidDataSource.setInitialSize(3);
        //设置最大的连接数量
        //druidDataSource.setMaxActive(5);
    }

}
