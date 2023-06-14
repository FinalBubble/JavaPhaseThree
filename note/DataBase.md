# 数据库

- 学习数据库阶段内容,主要学习的就是如何对数据进行增删改查操作

# DBMS

- DataBaseManagementSystem , 数据库管理系统(数据库软件) 

- 常见的DBMS :

  - MySQL : MySQL 公司产品08年被Sun收购 , 09年Sun被Oracle , 原MySQL团队从Oracle离职又创建了MariaDB. 市占率第一 

  - Oracle : Oracle公司当家产品 , 市占率第二 , 闭源产品

  - SqlServer : 微软公司产品 , 市占率第三 , 闭源产品 , .net编程语言+web服务软件+操作系统+数据库软件  

  - DB2 : IBM公司产品 , 闭源产品      

  - SQLite : 轻量级数据库 , 安装包只有几十K , 只有最基础的增删改查功能  

     

### SQL

- Structured Query Language : 结构化查询语言.  
- 通过这门语言让程序员和数据库软件进行交流  
- 举例 : insert into person values("刘德华",18);  

### 和数据库软件建立连接   

1. 通过命令行/终端和数据库软件建立连接  
   - 首先检查MySQL/MariaDB服务是否开启 : 在我的电脑/此电脑上右键-->管理 , 参见下图
     <img src="F:/BaiduNetdisk_Downloads/课程源码/javavn2206-master/06第三阶段笔记/06第三阶段笔记/企业微信截图_16688212038507.png" alt="img" style="zoom:67%;" />
   - 从开始菜单中找到MySQL/MariaDB-->MySQL Client 打开客户端 , 输入自己的密码显示Welcome ..... 说明建立好了连接
   - 退出指令 : exit
   - 建立连接指令 : mysql -uroot -p  回车后输入密码 , 再回车 
2. 通过三方的可视化工具和数据库软件建立连接 

### 数据库相关 

- 在MySQL数据库软件中保存数据需要先建库再建表 , 然后再往表里面添加数据

1. 查询所有数据库

   ```sql
   show databases;
   ```

2. 创建数据库

- 默认字符集格式 : create database 数据库名;

- 指定字符集格式 : create database 数据库名 charset=utf8/gbk;

- 举例 :

  ```sql
  create database db1;
  create database db2 charset = utf8;
  create database db3 charset = gbk;
  show databases;
  ```

3. 查询数据库信息

- 格式 : show create database 数据库名;

- 举例 :

  ```sql
  show create database db1;
  show create database db2;
  show create database db3;
  ```

4. 删除数据库

- 格式 : drop database 数据库名;

- 举例 :

  ```sql
  drop database db3;
  ```

5. 使用数据库

- 在执行表相关和数据相关的SQL语句之前必须使用了某个数据库,

- 格式 : use 数据库名;

- 举例 :

  ```sql
  use db1;
  use db2;
  ```

### 数据库相关练习题

1. 创建 mydb1和mydb2 数据库 字符集分别为utf8和gbk

   ```sql
   create database mybd1 charset = utf8;
   create database mybd1 charset = gbk;
   ```

2. 查询所有数据库检查是否创建成功

   ```sql
   show databases;
   ```

3. 检查两个数据库的字符集是否正确

   ```sql
   show create database mydb1;
   show create database mydb2;
   ```

4. 先使用mydb2 再使用 mydb1

   ```sql
   use mydb2;
   use mydb1;
   ```

5. 删除两个数据库

   ```sql
   drop database mydb1;
   drop database mydb2;
   ```

### 表相关

##### 数据库和表的概念

<img src="F:/BaiduNetdisk_Downloads/课程源码/javavn2206-master/06第三阶段笔记/06第三阶段笔记/企业微信截图_166882125995.png" alt="img" style="zoom: 67%;" />

- 执行表相关的SQL之前必须使用了某个数据库.

  ```sql
  use db1;
  ```

1. 创建表

- 格式: create table 名字(字段1名 类型,字段2名 类型,.....)charset=utf8/gbk;

- 举例: 

  ```sql
  create table person(name varchar(50),age int) charset = utf8;
  create table student(name varchar(50),chinese int,math int);
  ```

- 创建一个员工表emp , 保存名字,工资和工作 

  ```sql
  create table emp(name varchar(50),salary int,job varchar(20));
  ```

2. 查询所有表

```sql
show tables;
```

3. 查询表信息 

- 格式: show create table 表名;

- 举例:

  ```sql
  show create table student;
  ```

4. 查询表字段

- 格式: desc 表名;

- 举例:

  ```sql
  desc student;
  ```

5. 删除表

- 格式: drop table 表名;

- 举例:

  ```sql
  drop table student;
  ```

6. 修改表名

- 格式: rename table 原名 to 新名;

- 举例:

  ```sql
  rename table person to per;
  ```

### 表相关练习题

1. 创建数据库mydb3 字符集gbk并使用

   ```sql
   create database mydb3 charset = gbk;
   use mydb3;
   ```

2. 创建t_hero英雄表 , 有名字和年龄字段 , 默认字符集

   ```sql
   create table t_hero (name varchar(50),age int);
   ```

3. 修改表名为hero

   ```sql
   rename table t_hero to hero;
   ```

4. 查看hero表的字符集

   ```sql
   show create table hero;
   ```

5. 查询hero表字段

   ```sql
   desc hero;
   ```

6. 删除表hero

   ```sql
   drop table hero;
   ```

7. 删除数据库mydb3

   ```sql
   drop database mydb3;
   ```

### 表相关(续)

使用db1数据库 use db1;

1. 添加表字段 

- 最后面添加格式 : alter table emp add 字段名 类型;

- 最前面添加格式 : alter table emp add 字段名 类型 first;

- 某字段后面添加格式 : alter table emp add 字段名 类型 after 字段名;

- 举例 :

  ```sql
  alter table emp add gender varchar(5);
  alter table emp add id int first;
  alter table emp add dept varchar(20) after name;
  ```

2. 删除表字段

- 格式: alter table 表名  drop 字段名;

- 举例: 

  ```sql
  alter table emp drop dept;
  ```

3. 修改表字段

- 格式: alter table 表名 change 原名 新名 新类型;

- 举例:

  ```sql
  alter table emp change job dept varchar(5);
  ```

###  表相关练习题:

1. 创建数据库mydb4 , 字符集utf8并使用

   ```sql
   create database mydb4 charset = utf8;
   use mydb4;
   ```

2. 创建teacher表 , 具有姓名字段

   ```sql
   create table teacher (name varchar(50));
   ```

3. 添加表字段 : 最后添加age , 最前面添加id , age前添加salary工资

   ```sql
   alter table teacher add age int;
   alter table teacher add id int first;
   alter table teacher add salary int after name;
   ```

4. 删除age字段

   ```sql
   alter table teacher drop age;
   ```

5. 修改表名为t

   ```sql
   rename table teacher to t;
   ```

6. 删除表t

   ```sql
   drop table t;
   ```

7. 删除数据库mydb4

   ```sql
   drop database mydb4;
   ```



### 数据相关

操作数据必须保证已经使用了某个数据库并且已经准备好了保存数据的表 

```sql
create database mydb5 charset = utf8;
use mydb5
create table person(name varchar(50),age int);
```

1. 往表中插入数据

- 全表插入格式 : insert into 表名 values(值1,值2);

- 指定字段插入格式 : insert into 表名(字段1名,字段2名) values(值1,值2);

- 举例 :

  ```sql
  insert into person values("tom",18);
  insert into person (name) values ("jerry");
  ```

- 批量插入格式 : 

  - 全表插入格式 : insert into 表名 values(值1,值2),(值1,值2),(值1,值2);
  - 指定字段插入格式 : insert into 表名 (字段1名,字段2名) values(值1,值2),(值1,值2);

- 举例:

  ```sql
  insert into person values("lucy",21),("lily",22);
  insert into person (name) values ("danny"),("hanmeimei"),("lilei");
  ```

- 中文问题:

```sql
insert into person values("刘德华",50);
```

执行上面SQL语句报错的话 , 执行以下指令

```sql
set names gbk;
```




2. 查询数据

- 格式: select 字段信息 from 表名 where 条件;

- 举例:

  ```sql
  先:insert into person values('刘备',40),('关羽',30),('悟空',20),('八戒',10),('张学友',5);
  select name from person;
  select name,age from person;
  select * from person;
  select * from person where age > 20;
  查询tom的年龄
  select age from person where name = "tom";
  ```

3. 修改数据

- 格式: update 表名 set 字段名=值,字段名=值 where 条件;

- 举例: 

  ```sql
  update person set age = 88 where name = "刘备";
  update person set name = "黎明" where age = 5;
  update person set name = "张飞",age = 18 where name = "关羽";
  ```

4. 删除数据

- 格式: delete from 表名 where 条件;

- 举例:

  ```sql
  delete from person where name = "张飞";
  删除小于30岁的数据
  delete from person where age < 30;
  delete from person;
  ```

  ### 综合练习题

- 1. 创建数据库day1db , 字符集utf8并使用

     ```sql
     create database day1db charset = utf8;
     use day1db;
     ```

  2. 创建t_hero表, 有name字段 , 字符集utf8

     ```sql
     create table t_hero (name varchar(50));
     ```

  3. 修改表名为hero

     ```sql
     rename table t_hero to hero;
     ```

  4. 最后面添加价格字段money, 最前面添加id字段, name后面添加age字段

     ```sql
     alter table hero add money int;
     alter table hero add id int first;
     alter table hero add age int after name;
     ```

  5. 表中添加以下数据 : 1,李白,50,6888    2,赵云,30,13888    3,刘备,25,6888 

     ```sql
     insert into hero values(1,"李白",50,6888),(2,"赵云",30,13888),(3,"刘备",25,6888);
     ```

  6. 查询价格为6888的英雄名 

     ```sql
     select name from hero where money = 6888;
     ```

  7. 修改刘备年龄为52岁

     ```sql
     update hero set age = 52 where name = "刘备";
     ```

  8. 修改年龄小于等于50岁的价格为5000

     ```sql
     update hero set money = 5000 where age <= 50;
     ```

  9. 删除价格为5000的信息

     ```sql
     delete from hero where money = 5000;
     ```

  10. 删除表hero, 删除数据库day1db

      ```sql
      drop table hero;
      drop database day1db;
      ```



### 主键约束

- 主键 : 表示数据唯一性的字段称为主键  

- 约束 : 创建表时,给表字段添加的限制条件  

- 主键约束 : 限制主键的值唯一且非空.

- 举例: 

  ```sql
  create database day2db charset = utf8;
  use day2db;
  create table t1(id int primary key,name varchar(50));
  insert into t1 values (1,'aaa');
  insert into t1 values (1,"bbb"); //报错,主键值不能重复
  insert into t1 values (null,"ccc"); //报错,主键值不能为空
  ```

  

### 主键约束+自增 

- 自增规则 : 从历史最大值+1   

- 如何使用 : 

  ```sql
  create table t2(id int primary key auto_increment,name varchar(50));
  insert into t2 values (null,"aaa");
  insert into t2 values (null,"bbb");
  insert into t2 values (10,"ccc");
  insert into t2 values (null,"ddd");
  delete from t2 where id >= 10;
  insert into t2 values (null,"eee");
  ```

### SQL分类

- DDL : 数据定义语言, 包括数据库相关和表相关的SQL语句
- DML : 数据操作语言, 包括增删改查  
- DQL : 数据查询语言, 只包含select查询相关的SQL语句 
- TCL :  事务控制语言, 包含和事务相关的内容 
- DCL : 数据控制语言, 包含用户管理,权限分配相关SQL

### 数据类型

- 整数 : int(m) 和 bigint(m) , bigint相当于Java中的long , m代表显示长度 , m=5 , 存18会得到00018 ,  需要结合zerofill关键字使用
  举例 :

  ```sql
  create table t3 (age int(5) zerofill);
  insert into t3 values (18);
  select * from t3;
  ```

- 浮点数 : double(m,d) , m代表总长度 , d代表小数长度 , m=5 , d=3 , 23.123
  举例 : 

   ```sql
  create table t4(price double(5,3));
  insert into t4 values(23.123);
  insert into t4 values(23.1236); //仍然保留总长度5位,小数3位,并四舍五入
  insert into t4 values(233.123); //超出长度,会报错
   ```

- 字符串 :

  - char(m) : 固定长度 , m=5 , 存 "abc" 占5个字符长度 , 执行效率略高 , 当存储内容长度固定时使用 , 比如 : 性别 , m最大值255
  - varchar(m) : 可变长度 , m=5 , 存 "abc" 占3个字符长度 , 更节省存储空间 , m最大值65535 , 长度在255以内的建议使用
  - text(m) : 可变长度 , m最大值65535 , 建议长度大于255时使用  

- 日期 :

  - date : 保存年月日

  - time : 保存时分秒

  - datetime : 保存年月日时分秒,默认值null

  - timestamp(时间戳 , 距离1970年1月1日的毫秒数) : 保存年月日时分秒,默认值为当前系统时间
    测试 : 

    ```sql
    create table t5(t1 date,t2 time,t3 datetime,t4 timestamp);
    insert into t5 values ("2022-11-19",null,null,null);
    insert into t5 values (null,"16:45:30","2022-11-19 16:45:30",null);
    ```


### 导入*.sql 批处理文件  

- 把emp.zip解压出来得到一个emp.sql文件 , 把这个文件放到某个盘的根目录 , 比如D盘根目录 , 然后在命令行执行以下指令

- 在客户端中执行   

  ```sql
  source f:/emp.sql;  
  ```

- 执行以下SQL语句 , 检查是否成功

  ```sql
  show databases; //检查里面是否多了一个 empdb;
  show tables; //会出现两个表 emp 和 dept
  select * from emp; //检查里面的数据
  ```

- 如果出现乱码执行  

  ```sql
  set names utf8;
  ```

### 去重distinct

1. 查询员工表中有哪几种不同的工作?

   ```sql
   select job from emp;
   select distinct job from emp;
   ```

2. 查询员工表中有哪几个不同的部门id?  

   ```sql
   select distinct dept_id from emp;
   ```


### is null 和 is not null

1. 查询没有上级领导的员工姓名

   ```sql
   select name from emp where manager is null;
   ```

2. 查询有上级领导的员工姓名

   ```sql
   select name from emp where manager is not null;
   ```

### and 和 or

- 多个条件同时满足时使用and
- 多个条件满足一个就可以时 , 使用or

1. 查询1号部门工资高于2000的员工信息

   ```sql
   select * from emp where dept_id = 1 and sal > 2000;
   ```

2. 查询3号部门的员工或者工资等于5000的员工信息

   ```sql
   select * from emp where dept_id = 3 or sal = 5000;
   ```

3. 查询孙悟空和猪八戒的员工信息

   ```sql
   select * from emp where name = "孙悟空" or name = "猪八戒";
   ```



### 比较运算符   > <  >= <=  =  !=和<>

1. 查询工资大于等于3000的员工信息

   ```sql
   select * from emp where sal >= 3000;
   ```

2. 查询工作不是程序员的员工信息(两种写法)

   ```sql
   select * from emp where job != "程序员";
   select * from emp where job <> '程序员';
   ```

### between x and y  两者之间

```sql
查询工资在2000到3000之间的员工信息
select * from emp where sal >= 2000 and sal <= 3000;
select * from emp where sal between 2000 and 3000;

查询工资不在2000到3000之间的员工信息
select * from emp where sal not between 2000 and 3000;
```

### in关键字

- 当查询某个字段的值为多个值的时候使用in

​	查询工资等于5000,1500,3000的员工信息

```sql
select * from emp where sal = 5000 or sal = 1500 or sal = 3000; //效率更高
select * from emp where sal in (5000,1500,3000);
```

### 综合练习题

1. 查询1号部门有哪几种不同的工作?

   ```sql
   select distinct job from emp where dept_id = 1;
   ```

2. 查询1号部门中有上级领导的员工信息

   ```sql
   select * from emp where dept_id = 1 and manager is not null;
   ```

3. 查询工作是程序员,销售和人事的员工信息

   ```sql
   select * from emp where job in ("程序员","销售","人事");
   ```

4. 查询有奖金的员工信息  

   ```sql
   select * from emp where comm > 0;
   ```

5. 查询工资不在1000-2000之间的员工信息

   ```sql
   select * from emp where sal not between 1000 and 2000;
   ```

### 模糊查询 like  

- % : 代表0或多个未知字符
- _ : 代表1个未知字符
- 举例 :
      以x开头                 x%
  	以x结尾                 %x
  	包含x                     %x%
  	第二个字符是x      _x%
  	以x开头以y结尾    x%y
  	第二个是x倒数第三个是y      _x%y__

1. 查询姓孙员工信息  

   ```sql
   select * from emp where name like "孙%";
   ```

2. 查询名字以精结尾的员工姓名

   ```sql
   select name from emp where name like "%精";
   ```

3. 查询工作第二个字是售的员工姓名和工作

   ```sql
   select name,job from emp where job like "_售%";
   ```

4. 查询名字中包含僧并且工资大于2000的员工姓名和工资

   ```sql
   select name,sal from emp where name like "%僧%" and sal > 2000;
   ```

### 排序  order by

- 格式: order by 字段名 asc(默认升序)/desc(降序);

- description 描述

  descend 降序

1. 查询员工姓名和工资,按照工资升序

   ```sql
   select name,sal from emp order by sal;
   ```

2. 查询员工姓名和工资,按照工资降序

   ```sql
   select name,sal from emp order by sal desc;
   ```

3. 查询每个员工的姓名,工资和部门id按照部门id升序排序,如果部门id相同则按照工资降序排序

   ```sql
   select name,sal,dept_id from emp order by dept_id,sal desc;
   ```

### 分页查询

- 格式 : limit 起始下标,请求的条数(每页的条数)

- 举例 : 起始下标 = (请求页数-1) * 每页条数

  查询第1页的5条数据(1-5条)        limit 0, 5  

  查询第2页的5条数据(6-10条)      limit 5, 5

  请求第1页的10条数据             limit 0,10

  请求第3页的10条数据             limit 20,10

  请求第8页的10条数据             limit 70,10

  请求第6页的8条数数据            limit 40,8

1. 查询按照工资升序排序的第一页的3条数据

   ```sql
   select * from emp order by sal limit 0,3;
   select * from emp order by sal limit 3; //必须为第一页
   ```

2. 按照入职日期(hiredate) 升序排序 查询第3页的3条数据

   ```sql
   select * from emp order by hiredate limit 6,3;
   ```

3. 查询工资最高的员工信息 

   ```sql
   select * from emp order by sal desc limit 1; //必须为第一页
   select * from emp order by sal desc limit 0,1;
   ```

4. 查询按照工资降序第2页的5条数据

   ```sql
   select * from emp order by sal desc limit 5,5;
   ```



### 综合练习题

1. 查询员工表中3号部门工资高于1500的员工信息

   ```sql
   select * from emp where dept_id = 3 and sal > 1500;
   ```

2. 查询2号部门员工或者没有领导的员工信息

   ```sql
   select * from emp where dept_id = 2 or manager is null;
   ```

3. 查询有领导的员工姓名,工资按照工资降序排序

   ```sql
   select name,sal from emp where manager is not null order by sal desc;
   ```

4. 查询2号和3号部门的员工姓名和入职日期hiredate , 按照入职日期降序排序

   ```sql
   select name,hiredate from emp where dept_id in (2,3) order by hiredate desc;
   ```

5. 查询名字中包含僧和包含精的员工姓名

   ```sql
   select name from emp where name like "%僧%" or name like "%精%";
   ```

6. 查询工资高于2000的工作有哪几种?

   ```sql
   select distinct job from emp where sal > 2000;
   ```

7. 查询工资升序第4页的2条数据

   ```sql
   select * from emp order by sal limit 6,2;
   ```

### 别名 

给查询字段起别名

```sql
select name from emp;
select name as "姓名" from emp;
select name "姓名" from emp;
select name 姓名 from emp;
```

### 数值计算 + - \* / %

1. 查询每个员工的姓名 , 工资和年终奖(5个月的工资)

   ```sql
   select name,sal,5*sal 年终奖 from emp;
   ```

2. 给3号部门的员工每人涨薪5块钱  

   ```sql
   update emp set sal = sal + 5 where dept_id = 3;
   ```

### 聚合函数

- 可以对查询的多条数据进行统计查询,  统计方式包括 : 求平均值,最大值,最小值,求和,计数

1. 平均值avg(字段名)

- 查询1号部门的平均工资

  ```sql
  select avg(sal) from emp where dept_id = 1;
  ```

- 查询销售的平均工资

  ```sql
  select avg(sal) from emp where job = "销售";
  ```

2. 最大值max(字段名)

- 查询程序员的最高工资

  ```sql
  select max(sal) from emp where job = "程序员";
  ```

3. 最小值min(字段名)

- 查询3号部门的最低工资

  ```sql
  select min(sal) from emp where dept_id = "3";
  ```

4. 求和sum(字段名)

- 查询2号部门的工资总和

  ```sql
  select sum(sal) from emp where dept_id = 2;
  ```

5. 计数count(*)

- 查询程序员的数量

  ```sql
  select count(*) from emp where job = "程序员";
  ```



### 综合练习

1. 查询1号部门名字中包含僧的员工信息

   ```sql
   select * from emp where dept_id = 1 and name like "%僧%";
   ```

2. 查询2号和3号部门中工资高于1500的员工人数

   ```,
   select count(*) from emp where dept_id in (2,3) and sal > 1500;
   ```

3. 查询名字里面包含精的最高工资

   ```sql
   select max(sal) from emp where name like "%精%";
   ```

4. 查询程序员的平均工资

   ```sql
   select avg(sal) from emp where job = "程序员";
   ```

5. 查询销售的最低工资

   ```sql
   select min(sal) from emp where job = "销售";
   ```

6. 查询有领导的员工人数 

   ```sql
   select count(*) from emp where manager is not null;
   ```

7. 查询3号部门的人数和平均工资,起别名为平均工资

   ```sql
   select count(*) 人数,avg(sal) 平均工资 from emp where dept_id = 3;
   ```

### 分组查询group by  

- 将某个字段相同值的数据划分为一组 , 然后以组为单位进行统计查询  

1. 查询每个部门的平均工资

   ```sql
   select dept_id,avg(sal) from emp group by dept_id;
   ```

2. 查询每种工作的最高工资

   ```sql
   select job,max(sal) from emp group by job;
   ```

3. 查询每个部门的最高工资

   ```sql
   select dept_id,max(sal) from emp group by dept_id;
   ```

4. 查询每种工作的人数

   ```sql
   select job,count(*) from emp group by job;
   ```

5. 查询每个部门工资高于2000的人数

   ```sql
   select dept_id,count(*) from emp where sal > 2000 group by dept_id;
   ```

6. 查询每个部门有领导的员工的人数

   ```sql
   select dept_id,count(*) from emp where manager is not null group by dept_id;
   ```

### having关键字

- where后面只能写普通字段的条件,不能写聚合函数条件

  ```sql
  select dept_id,avg(sal) from emp where avg(sal) >2000 group by dept_id; //报错
  ```

- having后面可以包含聚合函数的条件 , 需要和group by结合使用 , 写在group by的后面

1. 查询每个部门的平均工资要求平均工资大于2000

   ```sql
   select dept_id,avg(sal) from emp group by dept_id having avg(sal) > 2000;
   ```

2. 查询每种工作的人数,只查询人数大于1的

   ```sql
   select job,count(*) from emp group by job having count(*) > 1;
   select job,count(*) c from emp group by job having c > 1;
   ```

3. 查询每个部门的工资总和,只查询有领导的员工, 并且要求工资总和大于5400

   ```sql
   select dept_id,sum(sal) s from emp where manager is not null group by dept_id having s >5400;
   ```

4. 查询每个部门的平均工资, 只查询工资在1000到3000之间的,并且过滤掉平均工资低于2000的

   ```sql
   select dept_id,avg(sal) a from emp where sal between 1000 and 3000 group by dept_id having a >= 2000;
   ```



### 各个关键字的顺序

```sql
select * from 表名 where 普通字段条件 group by 分组字段名 having 聚合函数条件 order by 排序字段名 desc limit 起始下标,请求条数;
```



### 子查询(嵌套查询)

```sql
use empdb;
```

1. 查询工资大于2号部门平均工资的员工信息

   ```sql
   select avg(sal) from emp where dept_id = 2;
   select * from emp where sal > (select avg(sal) from emp where dept_id = 2);
   ```

2. 查询工资高于程序员最高工资的员工信息

   ```sql
   select max(sal) from emp where job = "程序员";
   select * from emp where sal > (select max(sal) from emp where job = "程序员");
   ```

3. 查询工资最高的员工信息

   ```sql
   select * from emp where sal = (select max(sal) from emp);
   ```

4. 查询和孙悟空相同工作的员工信息

   ```sql
   select * from emp where job = (select job from emp where name = "孙悟空") and name != "孙悟空";
   ```

5. 查询拿最低工资员工的同事们的信息(同事指同一部门)

   ```sql
   select dept_id  from emp where sal = (select min(sal) from emp);
   select * from emp where dept_id = (select dept_id  from emp where sal = (select min(sal) from emp)) and sal != (select min(sal) from emp);
   ```

### 关联关系

- 指一个项目中创建的表和表之间存在的业务关系

- 有哪几种关系?

  - 一对一 : 有AB两张表,A表中一条数据对应B表中的一条数据, 同时B表中的一条数据也对应A表中的一条数据

  <img src="F:/BaiduNetdisk_Downloads/课程源码/javavn2206-master/06第三阶段笔记/06第三阶段笔记/企业微信截图_16692024904208.png" alt="img" style="zoom:50%;" />

  - 一对多 : 有AB两张表,A表中一条数据对应B表中的多条数据, 同时B表中的一条数据对应A表中的一条

  <img src="F:/BaiduNetdisk_Downloads/课程源码/javavn2206-master/06第三阶段笔记/06第三阶段笔记/企业微信截图_16692024358246-1669202449611.png" alt="img" style="zoom:50%;" />

  - 多对多 : 有AB两张表,A表中一条数据对应B表中的多条数据, 同时B表中的一条数据也对应A表中的多条

  <img src="F:/BaiduNetdisk_Downloads/课程源码/javavn2206-master/06第三阶段笔记/06第三阶段笔记/企业微信截图_16692024696110.png" alt="img" style="zoom:50%;" />

### 表和表之间如何建立关系,通过外键字段

- 一对一 :  在AB 任意一张表里面添加一个建立关系的字段 , 指向另外一张表的主键 

- 一对多 :  在一对多的两张表中 , 在"多"的表里面添加建立关系的字段(外键) , 指向另外一张表的主键  

- 多对多 :  创建一个单独的关系表 , 里面至少包含两个字段分别指向另外两个表的主键

### 关联查询

- 查询存在关联关系的表的查询方式称为关联查询 
- 关联查询的方式包括: 等值连接, 内连接, 外连接 

### 等值连接

- 格式 : select * from A,B where 关联关系;

  1. 查询每个员工的姓名和对应的部门名称

     ```sql
     select e.name,d.name from emp e,dept d where dept_id = d.id;
     ```

  2. 查询工资高于2000的员工的姓名和对应的部门名称

     ```sql
     select e.name,d.name from emp e,dept d where dept_id = d.id and sal > 2000;
     ```

### 内连接

- 格式: select * from A join B on 关联关系 where 其他条件;

  查询工资高于2000的员工的姓名和对应的部门名称

  ```sql
  select e.name,d.name from emp e join dept d on e.dept_id = d.id where sal > 2000;
  ```

### 外连接

- 等值连接和内连接查询到的是两个表的交集数据  

- 外连接查询到的是一张表的全部和另外一张表的交集  

- 格式: select * from A left/right join B on 关联关系;

  ```sql
  insert into emp(name,sal) values("灭霸",5);
  ```

1. 查询所有员工姓名和对应的部门名称

   ```sql
   select e.name,d.name from emp e left join dept d on dept_id = d.id;
   ```

2. 查询所有部门的名称,地址, 和对应的员工姓名,工资.

   ```sql
   select d.name 部门名称,loc,e.name 员工姓名,sal from emp e right join dept d on e.dept_id = d.id;
   select d.name 部门名称,loc,e.name 员工姓名,sal from dept d left join emp e on e.dept_id = d.id;
   ```

### 关联查询总结

1. 如果需要同时查询多张表的数据使用关联查询
2. 关联查询包括 : 等值连接,内连接和外连接
3. 等值连接和内连接查询的是两个表的交集数据, 推荐使用内连接
4. 如果需要查询一张表的全部和另外一张表的交集时 , 使用外连接,只需要掌握左外即可,因为表的位置可以交换 