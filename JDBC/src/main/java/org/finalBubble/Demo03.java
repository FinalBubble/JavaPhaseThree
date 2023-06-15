package org.finalBubble;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        // 1. 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root", "root");
        System.out.println(conn);
        // 2. 创建执行sql语句的对象，传输器对象
        Statement statement = conn.createStatement();
        // 3. 执行sql
        // 3.1 执行插入数据的sql
        //statement.execute("insert into emp (name) values ('tom')");
        // 3.2 执行修改数据的sql，将tom改为jerry
        //statement.execute("update emp set name = 'jerry' where name = 'tom'");
        // 3.3 执行删除数据的sql，将jerry删除
        //statement.execute("delete from emp where name = 'jerry'");
        // 3.4 执行查询数据的sql，得到结果集
        ResultSet resultSet = statement.executeQuery("select name, sal from emp");
        while (resultSet.next()){ // 判断是否有值
            // 获取游标执行的这个数据的某一个字段的值，通过字段名获取
            //String name = resultSet.getString("name");
            //double sal = resultSet.getDouble("sal");
            // 通过查询数据的位置顺序获取数据
            String name = resultSet.getString(1);
            double sal = resultSet.getDouble(2);
            System.out.println(name+":"+sal);
        }
        // 4. 关闭连接
        conn.close();
        System.out.println("执行完成！");
    }
}
