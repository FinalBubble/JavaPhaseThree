### JDBC

- Java DataBase Connectivity: Java数据库连接 
- 学习JDBC主要学习的就是如何通过Java语言和数据库软件进行连接并执行SQL语句.
- JDBC是Sun公司提供的一套用于Java语言和数据库软件进行连接的API (Application Programma Interface)
- 为什么Sun公司定义JDBC系列接口?
  Sun公司为了避免Java程序员,每一种数据库软件都学习一套全新的方法,通过JDBC接口将方法名定义好, 让各个数据库厂商根据此接口中的方法名写各自的实现类(就是一个jar文件, 称为数据库的驱动) ,这样Java程序员只需要掌握JDBC接口中方法的调用,即可访问任何数据库软件 
- 如何通过JDBC连接数据库并执行SQL语句
  1. 创建module,Maven工程名为JDBC01
  2. 复制以下MySQL驱动的依赖

```html
<!-- 连接MySQL数据库的依赖 -->
<dependencies>
   <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.15</version>
    </dependency>
</dependencies>
```

3. 刷新maven   
4. 检查工程目录中 external Libraries 里面是否出现了mysql相关的jar包



### 添加Demo01

```java
package org.finnalBubble;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //1.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root", "root");
        System.out.println("连接器:"+conn);
        //2.创建执行sql语句的对象,传输器对象
        Statement s = conn.createStatement();
        //3.准备并执行sql
        s.execute("create table jdbc01 (name varchar(20))");
        //4.关闭连接
        conn.close();
        System.out.println("创建完成!");
    }
}

```

### 创建Demo02

```java
package org.finnalBubble;

public class Demo02 {
    //删除表jdbc01
    public static void main(String[] args) throws SQLException {
        //1.创建连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root", "root");
        //2.创建传输器对象
        Statement s = conn.createStatement();
        //3.准备并执行SQL
        s.execute("drop table jdbc01");
        //4.关闭连接
        conn.close();
        System.out.println("执行完成!");
    }
}

```

### Statement执行SQL语句的方法

- execute(sql); 此方法可以执行任意SQL语句,推荐执行DDL(数据库相关和表相关的SQL语句)
- int rows = executeUpdate(sql); 此方法执行增删改相关的SQL语句  ,方法返回值是一个整数 , 表示影响的行数
- ResultSet rs =  executeQuery(sql); 此方法执行查询相关的SQL语句 ,方法的返回值为结果集对象, 里面装着查询回来的所有数据

### 创建Demo03

```java
package org.finnalBubble;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        //1.创建连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root", "root");
        //2.创建传输器对象
        Statement s = conn.createStatement();
        //3.执行sql
        //>1执行插入数据的sql
        //s.executeUpdate("insert into emp (name) values ('tom')");
        //>2执行修改数据的sql,将tom改为jerry
        //s.executeUpdate("update emp set name = 'jerry' where name = 'tom'");
        //>3执行删除数据的sql,将jerry删除
        //s.executeUpdate("delete from emp where name = 'jerry'");
        //>4执行查询数据的sql,得到结果集
        ResultSet rs = s.executeQuery("select name,sal from emp");
        while (rs.next()) { //判断是否有值
            //获取游标执行的这个数据的某一个字段的值,通过字段名获取
            //String name = rs.getString("name");
            //double sal = rs.getDouble("sal");
            //通过查询数据的位置顺序获取数据
            String name = rs.getString(1);
            double sal = rs.getDouble(2);
            System.out.println(name+":"+sal);
        }
        //4.关闭连接
        conn.close();
        System.out.println("执行完成!");
    }
}

```

### 创建DBUtils

```java
package org.finnalBubble;

public class DBUtils {
    public static Connection getConn() throws SQLException {
        //1.创建连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root", "root");
        return conn;
    }
}

```

### 创建Demo04

```java
package org.finnalBubble;

public class Demo04 {
    public static void main(String[] args) {
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select name from emp");
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

### 创建Demo05

```java
package org.finnalBubble;

public class Demo05 {
    public static void main(String[] args) {
        //创建一个hero表,有id,name,money,id主键自增
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            s.execute("create table hero (id int primary key auto_increment,name varchar(50),money int)");
            System.out.println("执行完成!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

### 创建Demo06

```java
package org.finnalBubble;

public class Demo06 {
    //接收用户输入的英雄名和价格,并添加到hero表中
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入英雄名:");
        String name = sc.nextLine();
        System.out.println("请输入英雄价格:");
        int money = sc.nextInt();
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "insert into hero values (null,'"+name+"',"+money+")";
            s.executeUpdate(sql);
            System.out.println(sql);
            System.out.println("执行完成!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

```

### 创建Demo07

```java
public class Demo07 {
    //把英雄表中所有的信息查询出来并在控制台输出
    public static void main(String[] args) {
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            //执行查询
            ResultSet rs = s.executeQuery("select * from hero");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int money = rs.getInt(3);
                System.out.println(id+":"+name+":"+money);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### 数据库连接池DBCP

- DataBaseConnectionPool , 数据库连接池

- 作用 : 将连接重用 , 从而提高执行效率

- 如何使用数据库连接池?

  ```html
  <!-- 数据库连接池 -->
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.21</version>
  </dependency>
  ```

<img src="F:/BaiduNetdisk_Downloads/课程源码/javavn2206-master/06第三阶段笔记/06第三阶段笔记/企业微信截图_16694458323077.png" alt="img" style="zoom: 67%;" />

### 创建Demo08

```java
/**
 * 使用连接池的测试类
 */
public class Demo08 {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        DruidDataSource ds = new DruidDataSource();
        //设置数据库连接信息
        ds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("root");
        //设置初始连接数量
        ds.setInitialSize(3);
        //设置最大的连接数量
        ds.setMaxActive(5);
        //从连接池中获取连接
        Connection conn = ds.getConnection();
        System.out.println("连接对象:"+conn);
    }
}
```

### DBUtils优化1

```java
public class DBUtils {
     public static Connection getConn() throws SQLException {
        //创建连接池对象
        DruidDataSource ds = new DruidDataSource();
        //设置数据库连接信息 url 用户名 密码
        ds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root");
        //设置初始连接数量
        ds.setInitialSize(3);
        //设置最大连接数量
        ds.setMaxActive(5);
        //从连接池中获取连接   异常抛出
        Connection conn = ds.getConnection();
        System.out.println("连接对象:"+conn);
        return conn;
    }
}
```

### DBUtils优化2

```java
public class DBUtils {
    private static DruidDataSource ds;
    static { //只在类加载的时候运行一次,作用:用于初始化
        //创建连接池对象
        ds = new DruidDataSource();
        //设计数据库连接信息
        ds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("root");
        //设置初始连接数量
        ds.setInitialSize(3);
        //设置最大的连接数量
        ds.setMaxActive(5);
    }
    public static Connection getConn() throws SQLException {
        //从连接池中获取连接
        Connection conn = ds.getConnection();
        return conn;
    }
}
```



### 注册登录

- 创建用户表

  ```sql
  use empdb;
  
  create table user(id int primary key auto_increment,username varchar(50),password varchar(50),nickname varchar(50))charset=utf8;
  ```

  

### 创建Demo09

```java
public class Demo09 {
    //注册:用户名,密码,昵称(nickname)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        System.out.println("请输入昵称:");
        String nickname = sc.nextLine();
        //插入数据
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            s.executeUpdate("insert into user values(null,'"+name+"','"+password+"','"+nickname+"')");
            System.out.println("执行成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### 创建Demo10

```java
public class Demo10 {
    //登录:输入用户名,密码
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            ResultSet rs = 
                    s.executeQuery("select count(*) from user where username='" + name + "' and password='" + password + "'");
            rs.next();
            int count = rs.getInt(1);
            if(count >0) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

- SQL注入 : 往本应该传值的地方,传递进的SQL语句,导致原有SQL语句的逻辑发生改变, 这个过程称为SQL注入

- PreparedStatement预编译的SQL执行对象 , 此对象可以将编译SQL语句的时间点提前,提前后可以将SQL语句逻辑部分提前锁死, 用户输入的内容将不能影响原有SQL语句的逻辑部分,从而解决了SQL注入的问题

- 如果SQL语句中存在变量,则必须使用PreparedStatement,解决SQL注入问题, 而且可以提高开发效率(避免了拼接字符串) 

- 如果SQL语句中没有变量,可以使用Statement或PreparedStatement

  


### Demo10优化

```java
package org.finnalBubble;

public class Demo10 {
    //登录(查询):输入用户名,密码
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {

            //当前?为占位符,当前sql为sql骨架
            String sql = "select count(*) from user where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //代码中的1和2代表的是?的位置,用户输入的变量会将?替换
            //sql代码逻辑已经编译提前锁死,现在用户输入的内容不会影响原有的sql的语义
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("登录成功!");
            }else {
                System.out.println("用户名或密码错误!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### 创建Demo11

```java
public class Demo11 {
    //完成登录,并且登录不成功时,需要知道是密码错误还是用户名不存在
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
            String sql = "select password from user where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //1代表是第一个问号
            ps.setString(1,username);
            //执行查询
            ResultSet rs = ps.executeQuery();
            //判断是否有数据
            if (rs.next()) {
                //1代表是查询出的第一个字段
                String pw = rs.getString(1);
                if (pw.equals(password)) {
                    System.out.println("登录成功!");
                } else {
                    System.out.println("密码错误!");
                }
            } else {
                System.out.println("用户名不存在!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

### 创建Demo12

```java
public class Demo12 {
    //实现注册功能,用户名不允许重复
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        System.out.println("请输入昵称:");
        String nickname = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
            //1.查询用户名是否存在
            String sql = "select id from user where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("用户名已经存在");
                return;
            }
            //2.注册:往user表中添加数据
            String insertSql = "insert into user values(null,?,?,?)";
            PreparedStatement insertPs = conn.prepareStatement(insertSql);
            insertPs.setString(1,username);
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
```

