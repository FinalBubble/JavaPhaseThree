package org.finalBubble;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo07 {
    //把英雄表中所有的信息查询出来并在控制台输出
    public static void main(String[] args) {
        try (
                Connection connection = DBUtil.getConn()
        ){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from hero ");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double money = resultSet.getDouble(3);
                System.out.println("{ id"+":"+id+", name:"+name + ", money:"+money+" }");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
