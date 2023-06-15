package org.finalBubble;

import java.sql.*;
import java.util.Scanner;

public class Demo11 {
    //完成登录,并且登录不成功时,需要知道是密码错误还是用户名不存在
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始登录流程：");
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密  码：");
        String password = scanner.next();
        try (Connection conn = DBUtil.getConn()) {
            Statement statement = conn.createStatement();
            String sql = "select password from user where username = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //代码中的1和2代表的是?的位置,用户输入的变量会将?替换
            //sql代码逻辑已经编译提前锁死,现在用户输入的内容不会影响原有的sql的语义
            preparedStatement.setString(1, name);
            System.out.println(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if (resultSet.getString(1).equals(password)){
                    System.out.println("登录成功");
                } else {
                    System.out.println("密码错误！");
                }
            } else {
                System.out.println("用户名不存在！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
