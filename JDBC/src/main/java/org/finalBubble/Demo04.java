package org.finalBubble;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        try(
                Connection connection = DBUtil.getConn()
                ) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from emp");
            while (resultSet.next()){
                String name = resultSet.getString(1);
                System.out.println(name);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
