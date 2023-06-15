package org.finalBubble;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Demo06 {
    //接收用户输入的英雄名和价格,并添加到hero表中

    public static void main(String[] args) {
        System.out.println("请输入英雄名和价格：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        double money = scanner.nextDouble();
        try (
                Connection connection = DBUtil.getConn()
        ){
            Statement statement = connection.createStatement();
            statement.execute("insert into hero " +
                    "(id, name, money) values ( null,'"+name+"','"+money+"')");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
