# JavaScript

### 什么是JavaScript

- 作用 : 负责给页面添加动态效果

- 语言特点 :

  - 属于脚本语言(不需要编译直接由浏览器解析执行)

  - 基于面向对象 

  - 属于弱类型语言  

```javascript
Java: String name = "tom";  int age = 18;  age = "abc"; //报错

JS: let name = "tom";  let age = 18;   age = "xyz"; //不报错 
```

- 安全性强 : JS语言只能访问浏览器内部的数据 , 浏览器以外电脑上的数据禁止访问 

- 交互性强 : 因为JS语言是嵌入到html页面中最终执行在客户端的语言 , 可以和用户直接进行交互 , 而像Java语言是运行在服务器的语言和用户交互需要借助于网络 , 所以交互性JS语言会更强一些

### 如何在HTML页面中添加JS语言

三种引入方式 :

- 内联: 在标签的事件属性中添加js代码 , 当事件触发时执行

  - 事件 : 就是浏览器窗口中发生的一些特定的交互瞬间

  - 点击事件 : 在用户点击元素时触发浏览器窗口中发生的一些特定的交互瞬间

- 内部 : 在html页面中的任意位置添加script标签 , 标签体内写js代码

- 外部 : 在单独的js文件中写js代码 , 然后在html页面中通过script标签的src属性引入到html页面

#### 变量

- JS属于弱类型语言

```javascript
Java: String name="tom";  int age = 18;  age="abc"; //报错

JS: let name="tom";  let age = 18;   age="xyz"; //不报错 
```

- let和var关键字的区别 , 作用域不同

  - 使用let声明的变量 , 为一个局部变量

  - 使用var声明的变量 , 不管在什么位置声明 , 都相当于是一个全局变量

```javascript
Java:
for(int i=0; i<10; i++){
 int y = i+1;
}
int z = i+y; //报错,i和y超出了自身的作用域

JS:
for(let i=0; i<10; i++){
 let y = i+1;
}
let z = i+y; //访问不到i和y,因为超出了作用域

for(var i=0; i<10; i++){
 var y = i+1;
}
var z = i+y; //能够访问到i和y的值 
```



#### 数据类型

- JavaScript中只有引用类型(对象类型)
- 常见的对象类型 :
  - number :  数值类型 , 相当于Java中所有数值类型的总和
  - String : 字符串 , 可以用单引号或双引号修饰 : 'tom' , "tom"
  - boolean : 布尔值 , true/false
  - undefined : 未定义 ,当变量只声明不赋值时 , 变量的类型为未定义
  - 获取变量类型的方式 : typeof 变量   

### 运算符

- 算术运算符: + - * / %,   JS除法会自动根据结果转换整数还是小数

  ```java
  - Java : int x = 5;  int y = 2;  x / y = 2;
  - JS : let x = 5; let y = 2;  x / y = 2.5;
  ```

- 关系运算符: > <  >=  <=  !=  == 和 ===

  - == : 先统一等号两边的类型 , 再比较值 : "666" == 666  true
  - === : 先比较类型 , 类型相同之后再比较值 : "666"==666  false

- 逻辑运算符 : &&   ||    !   

- 三目运算符 : 条件 ? 值1 : 值2

- 赋值运算符:  =  +=  -=  *= /= %=  ++  --

### 各种语句

- if else 
- while 
- do while 
- for 
- switch case 

### 方法/函数

- Java : public 返回值类型 方法名(参数列表) { 方法体 }

- JS : function 方法名(参数列表) { 方法体 }

- 常见的四种方法:

  - 无参无返回值
  - 无参有返回值
  - 有参无返回值
  - 有参有返回值

- 声明方法的三种方式 :

  1. function 方法名(参数列表) { 方法体 }
  2. let 方法名 = function(参数列表) { 方法体 }
  3. let 方法名 = new Function("参数1","参数2","方法体");

### NaN

- Not a Number: 不是一个数


- isNaN(x) 判断变量是否是NaN

### JavaScript对象分类

- 内置对象 : 包括String , number , boolean等


- BOM : Browser Object Model , 浏览器对象模型 , 包括和浏览器相关的内容


- DOM : Document Object Model , 文档对象模型 , 包括和页面标签相关的内容


### BOM浏览器对象模型

- window: 此对象里面的属性和方法称为全局的属性和方法,访问时可以省略掉window


- window中常见的方法:

  - alert("xxx")弹出提示框

  - confirm("xxx") 弹出确认框

  - prompt("xxx") 弹出文本框

  - isNaN(x) 判断变量是否是NaN

  - parseInt()和parseFloat()  把字符串转成整数或小数

  - console.log() 控制台输出

  - let timer = setInterval(方法,时间间隔) 开启定时器

  - clearInterval(timer) 停止定时器

  - setTimeout(方法,时间间隔)  开启只执行一次的定时器

- window对象中常见的属性

  - location位置

    - location.href  获取和修改浏览器的请求地址

    - location.reload()  刷新页面  

  - history历史

    - history.length  获取历史页面数量

    - history.back()   返回上一页面

    - history.forward()  前往下一页面  

    - history.go(n)     n=1是前往下1页面  n=-1 返回上一页面  n=2 前往下2个页面   n=0代表刷新

### DOM文档对象模型

- 包含和页面元素相关的内容

1. 通过选择器获取页面中的元素对象

   let 元素对象 = document.querySelector("选择器")

2. 通过元素的id获取元素对象  

   let 元素对象 = document.getElementById("元素id");

2. 获取和修改元素的文本内容 

   元素对象.innerText = "xxx";  修改文本内容

   元素对象.innerText     获取文本内容

3. 获取和修改input控件的值 

   控件对象.value = "xxx";  修改 

   控件对象.value 获取

4. 创建元素对象

   let 元素对象 = document.createElement("标签名");

5. 添加元素对象到某个元素里面

   document.body.appendChild(元素对象);

   父元素.appendChild(元素对象);

   父元素.append(元素对象,元素对象,元素对象);