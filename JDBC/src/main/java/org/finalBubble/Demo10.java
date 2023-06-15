package org.finalBubble;

import java.sql.*;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        //登录:输入用户名,密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始登录流程：");
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密  码：");
        String password = scanner.next();
        try (Connection conn = DBUtil.getConn()) {
            Statement statement = conn.createStatement();
            //ResultSet resultSet = statement.executeQuery("select username, password from user");
            //boolean flag = false;
            //while (resultSet.next()){
            //    if (resultSet.getString(1).equals(name) &&
            //            resultSet.getString(2).equals(password)){
            //        flag = true;
            //        break;
            //    }
            //}
            //if (flag){
            //    System.out.println("登录成功！");
            //} else {
            //    System.out.println("用户名或密码不正确！");
            //}
            //String sql = "select count(*) from user where username = '" +
            //        name + "'" + " and password = '" + password + "'";
            //System.out.println(sql);
            //ResultSet resultSet = statement.executeQuery(sql);
            //优化1
            //当前?为占位符,当前sql为sql骨架
            String sql = "select count(*) from user where username = ? and password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //代码中的1和2代表的是?的位置,用户输入的变量会将?替换
            //sql代码逻辑已经编译提前锁死,现在用户输入的内容不会影响原有的sql的语义
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            System.out.println(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count > 0) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
