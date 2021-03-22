### 创建表

- 建表语句的语法格式;

  ```mysql
  create table 表名（
  	字段名1 数据类型，
  	字段名2 数据类型，
  	字段名3 数据类型，
  	... ...
  ）；
  # 起名要见名知意
  ```

- Mysql中的数据类型

  ```mysql
  sql中的类型							对应java中的类型
  	---						----
  int		整型				int
  bigint  长整型			   long
  float	浮点型				float和double
  char	定长字符串		String
  varchar 变长字符串		StringBuffer和StringBuild
  date	日期类型
  BLOB	二进制大对象（存储图片，视频等流媒体信息）		Object
  CLOB	字符大对象	（存储较大文本，比如可以存储4G的字符串）Object
  
  # varchar
  1.根据存储的内容动态分配空间
  
  # char
  1.固定长度，存储性别 M F
  2.效率高，底层不会做判断
  3.若数据库中字段数据长度确定
  ```

- 建表

  ```mysql
  # 建立学生表
  学生信息包括 学号 姓名 班级编号 生日
  
  create table t_student(
      no bigint default 1,
      name varchar(255),
      sex char(1),
      classno varchar(255),
      birth char(10)
  );
  
  # 可以使用关键字 default 进行默认值的设定，否则默认为null
  ```

### 插入数据

- 语法格式

  ```mysql
  1. 一般写法
  insert into 表名(字段名1， 字段名2，字段名3 ...) values (值1，值2，值3)；
  # 要求字段的数量和值的数量要相同，并且数据类型要对应相同
  # 字段的顺序并不重要，重要的是前后要对应
  # 允许只插入一个字段后若干字段，其他字段将被赋予NULL
  # inser 一旦提交表格一定会多处一行数据,即使多的这一行记录的某一些字段是null，后期也没有办法再执行insert语句插入数据了，只能使用update进行更新
  
  2. 省略写法
  insert into  表名 values (值1，值2，值3)；
  # 若省略字段，则values中就必须要一一对齐并且，个数不能出错
  
  3. 一次写入多个行
  insert into 
  	表名(字段名1， 字段名2，字段名3 ...) 
  	values 
  	(值1，值2，值3,...)；
  	values
  	(值1，值2，值3，...);
  	
  	# 删除表 drop table if exists 表名;
  
  ```

- 添加删除列

  ``` mysql
  alter table {table_name} add {colum_name} varchar(20);
  alter table {table_name} drop column {column_name};
  alter table {table_name} modify ({column_name} varchar(10));
  ```

  

### 表的复制

- ### 语法格式

  ```Mysql
  1.
  create table 表名 as DQL语句；
  # 将查询结构当做表创建出来
  # 
  	create table emp1 as select * from emp;
  	create table emp2 as select ename,sal from emp;
  
  2. 将查询结果插入到表中
  insert into 表名 SELECT * FROM 表名；
  ```

### 修改数据

- 语法格式

  ```mysql
  update 表名 set 字段1=值，字段2=值 ... where 条件；
  # 注意没有条件表示整张表全部更新
  
  # 案例
  # 将部门10的 LOC 改为 SHANGHAI 名称改为人事部；
  UPDATE DEPT SET LOC='SHANGHAI', DNAME='RENSHIBU' WHERE DEPTNO=10;
  +--------+------------+----------+
  | DEPTNO | DNAME      | LOC      |
  +--------+------------+----------+
  |     10 | RENSHIBU   | SHANGHAI |
  |     20 | RESEARCH   | DALLAS   |
  |     30 | SALES      | CHICAGO  |
  |     40 | OPERATIONS | BOSTON   |
  +--------+------------+----------+
  
  UPDATE DEPT SET LOC='ZYK', DNAME='HANGZHOU' WHERE DEPTNO=10;
  +--------+-------+----------+
  | DEPTNO | DNAME | LOC      |
  +--------+-------+----------+
  |     10 | ZYK   | HANGZHOU |
  |     20 | ZYK   | HANGZHOU |
  |     30 | ZYK   | HANGZHOU |
  |     40 | ZYK   | HANGZHOU |
  
  ```

### 删除数据

- 语法格式

  ```mysql
  DELETE FROM 表名 WHERE 条件；
  # 案例
  # 删除10 部门的数据
  
  DELETE FROM DEPT WHERE DEPTNO =10;
  
  # 删除全部记录
  DELETE FROM DEPT;
  ```

### 约束

什么是约束？常见的约束是什么？

在表上强制执行的校验规则

```mysql
在创建表的时候为一些字段添加一些约束，其目的是保证数据的合法性、有效性、完整性。
1.非空约束 （not null）:被约束的字段不能为null
2.唯一约束	（unique key）： 约束的字段不能重复
3.主键约束	（primary key）：既不能为空又不能重复，唯一标识表的一行数据
4.外键约束	（foreign key）：用于当多个表有关联关系的时候

foreign key (DEPTNO) references DEPT(DEPTNO)
*5.check检查约束（check）Oracle 数据库支持，但MySql 目前不支持，根据当用户自己的需求限定某些列的值。
```

非空约束

```mysql
drop table if exist t_user;
create table t_user(
   id int,
   username varchar(255) not null
);
not null
```

唯一性约束

```mysql
1.列级约束
2.表级约束（多个字段联合添加约束 ）

# 唯一约束修饰的字段具有唯一性，不能重复。但是可以为null
# null 不是值， null 与null 之间不能视为相同
drop table if exist t_user;
create table t_user(
   id int,
   username varchar(255) unique,
   usercode varchar(255),
   useremail varchar(255),
    unique(usercode, useremail)
    # 多个字段联合添加约束
    #两个字段联合起来，不能重复
);
# 重复会报错

# not null 约束只有表级约束，没有列级约束

```

主键约束

```mysql
 # 不能为空，也不能重复
drop table if exist t_user;
create table t_user(
   id int primary key,
   username varchar(255) not null，
   email	varchar(255)
);

#主键相关术语
主键约束
主键字段
主键值

#主键的作用
1.表的设计三范式，第一范式：每一张表都应该有主键
2.主键的作用：主键字段上的值是一行记录在这张表中的唯一标识，就像身份证号一样，只要主键值不同就是两条完全不同的记录

#主键分类
根据主键字段的字段数量划分：
1.单一主键 （推荐）
2.复合主键（多个字段联合添加一个主键约束，不推荐使用，违背三范式）
根据主键的性质划分：
1.自然主键：主键值最好就是一个和业务没有关系的自然数
2.业务主键：主键的系统的业务挂钩 如：银行卡号和身份证号做主键（不推荐）
# 最好不要拿和业务挂钩的字段做主键，因为业务发生改变，主键值也会改变，变化会导致主键值重复
# 一张表只能有一个主键约束

# 主键值自增
drop table if exist t_user;
create table t_user(
   id int primary key auto_increment, # id 字段维护一个自增的数字
   username varchar(255) not null，
   email	varchar(255)
);
```

外键约束

```mysql
# 业务背景
设计数据库表，用来维护班级和学生的信息？

drop table if exist t_student;
drop table if exist t_class;

create table t_class(
    cno int primary key,
    cname varchar(255),
);

create table t_student(
    sno int,
    sname varchar(255),
    classno int,
    foreign key(classno) references t_class(cno)，
    primary key(sno)
    # classno 字段的值只能是 t_class表中的cno有的值
);

# 外键值可以为null

# 外键字段引用其他表的字段的时候不一定要引用主键字段，但被引用的字段一定要有唯一性
# 否则字表的外键值引用的是主表的哪一个键值就说不清了

# 一般情况下，引用主键字段

可以指定添加了外键约束的字段引用了其他的字段
建表顺序要求
```

表建立完成后建立约束

```mysql
alter table {table_name } add constraint 
```







### 删除一张表

```mysql
truncate table EMP；
# 删除之前要再三确认，不可逆的过程
# 删除表中的数据，但是不删除表本身
 
drop table 表名；
drop table if exist 表名;
# 删除表的时候，经常会遇到多个表的关联的情况，多个表的关联不能随意删除，需要使用级联删除 cascade
drop table cascade constraint;
#修改表的名字
rename A to B;
```






### 视图

```mysql
# 删除视图
drop view;
```





若一个视图基于多个基表，则一次修改就只能修改或者删除一个基本表中的视图，一般都是不从视图删除数据的。









 









