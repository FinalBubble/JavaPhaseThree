package org.finalBubble;

import java.sql.Connection;
import java.sql.Statement;

public class Demo05 {
    public static void main(String[] args) {
        //创建一个hero表,有id,name,money,id主键自增
        try (
                Connection connection = DBUtil.getConn()
                ){
            Statement statement = connection.createStatement();
            statement.execute("create table hero " +
                    "(id int primary key auto_increment, name varchar(50), money double) ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
