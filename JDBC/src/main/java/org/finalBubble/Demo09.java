package org.finalBubble;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo09 {
    //注册:用户名,密码,昵称(nickname)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始注册流程：");
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入昵  称：");
        String nickname = scanner.next();
        System.out.println("请输入密  码：");
        String password = scanner.next();
        try (Connection conn = DBUtil.getConn()){
            Statement statement = conn.createStatement();
            statement.execute("insert into user values(null,'"+name+"','"+password+"','"+nickname+"')");
            System.out.println("执行成功！");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
