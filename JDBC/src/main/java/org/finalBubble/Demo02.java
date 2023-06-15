package org.finalBubble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        // 1. 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root", "root");
        System.out.println(conn);
        // 2. 创建执行sql语句的对象，传输器对象
        Statement statement = conn.createStatement();
        // 3. 准备并执行sql
        statement.execute("drop table jdbcDemo");
        // 4. 关闭连接
        conn.close();
        System.out.println("删除成功！");
    }
}
