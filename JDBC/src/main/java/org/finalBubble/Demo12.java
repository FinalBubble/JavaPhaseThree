package org.finalBubble;

import java.sql.*;
import java.util.Scanner;

public class Demo12 {
    //实现注册功能,用户名不允许重复
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始登录流程：");
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密  码：");
        String password = scanner.next();
        System.out.println("请输入昵  称：");
        String nickname = scanner.next();
        try (Connection conn = DBUtil.getConn()) {
            //Statement statement = conn.createStatement();
            //String sql = "select count(*) from user where username = ?";
            //PreparedStatement preparedStatement;
            //preparedStatement = conn.prepareStatement(sql);
            //preparedStatement.setString(1, name);
            //ResultSet resultSet;
            //resultSet= preparedStatement.executeQuery();
            //resultSet.next();
            //int count = resultSet.getInt(1);
            //if (count > 0) {
            //    System.out.println("用户已存在！");
            //} else {
            //    sql = "insert into user values(null,'"+name+"','"+password+"','"+nickname+"')";
            //    preparedStatement = conn.prepareStatement(sql);
            //    preparedStatement.execute();
            //    System.out.println("注册成功！");
            //
            //}
            //1.查询用户名是否存在
            String sql = "select id from user where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("用户名已经存在");
                return;
            }
            //2.注册:往user表中添加数据
            String insertSql = "insert into user values(null,?,?,?)";
            PreparedStatement insertPs = conn.prepareStatement(insertSql);
            insertPs.setString(1,name);
            insertPs.setString(2,password);
            insertPs.setString(3,nickname);
            //执行插入
            insertPs.executeUpdate();
            System.out.println("注册成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
