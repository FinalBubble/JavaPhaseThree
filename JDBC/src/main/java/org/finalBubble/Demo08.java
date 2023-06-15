package org.finalBubble;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;

/**
 * 使用连接池的测试类
 */
public class Demo08 {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();
        //设置数据库连接信息
        druidDataSource.setUrl("jdbc:mysql://localhost:3307/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        //设置初始连接数量
        druidDataSource.setInitialSize(3);
        //设置最大的连接数量
        druidDataSource.setMaxActive(5);
        //从连接池获取连接
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
    }
}
