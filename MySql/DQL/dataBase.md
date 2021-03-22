## 数据库

### 数据库的基本概念

数据库的**增删改查**,数据库的简单管理系统,使用简单的sql语句,与语言无关

常见的数据库的管理系统:

- Oracle(甲骨文) 传统行业 银行 政府
- MySql免费开源(京东 阿里)
- SB
- Microsoft SqlServer(应用比重不是很大)

```
提供了简洁的数据库操作借口,底层基于IO流
```

ObjectOutputStream --->Java对象--->序列化到文件中

反序列化

### MySql

> 登录

```mysql
#登录MySQL
mysql -uroot -p******
```

>  一些概念的理解

- **DB**: DataBase实际上在硬盘上以文件的形式存在
- **DBMS**: DataBase Management System(数据库管理系统,用来管理数据库)
- **SQL**:标准通用的**结构化查询语言**, 适合于所有的数据库产品, 属于高级语言. SQL的编译由DBMS完成

```
DBMS负责执行SQL语言,通过执行SQL语言来操作DB中的数据
```

> 表 table

table是数据库的基本组成单元,所有的数据都以表格的形式组织,目的是可读性强.

一个表包含行和列

行: 数据/记录

列: 字段

​	学号(int)  姓名(varchar, 可变字符串)  年龄(int)

​	1

​    2

每一个字段因该包含有:字段名 数据类型 相关约束(如:不能为空)

> 通用SQL语句

1. DQL(数据查询语言): 查询语句 SELECT(重点)

2. DML(数据操作语言): insert delete update 对**表中的数据**进行增删改(重点)

3. DDL(数据定义语言): create drop alter 对**表的结构**进行增删改

4. TCL(事务控制语言):commit rollback
5. DCL(数据控制语言):grant 授权 revole 撤销权限

> 数据导入

1. 登录数据库管理系统

2. 查看有哪些数据库

   ```bash
   show databases; 
   #(这个不是SQL语句,是MySQL的命令, 在Orale数据库管理系统就不能用了)
   #分号不能漏掉
   ```

   

3. 创建属于我们自己的数据库

   ```bash
   create database zhangeaky;
   #依然是MySQL的命令
   ```

4. 使用zhangeaky数据库的数据

   ```
   use zheangky;
   ```

5. 查看当前的数据库中有哪些表(tables)?

   ```mysql
   show tables;
   desc 表名；#查看表的结构
   ```

6. 初始化数据

   ```bash
   # .sql 文件中编写了大量的sql语句
   # .sql文件太大的时候用source命令进行初始化
   # 在 source sql 脚本文件之前一定要先建立自己的数据库并use
   source XXXXXX.sql;
   sql文件:
   
   ```

7. 删库

   ```bash
   drop database zhangeaky；
   ```

   ```mysql
   select database(); # 查看当前是哪一个数据库
   desc {名称}；
   show create table emp;  查看建表语句
   ```

## MySql语句

### 查询语句(DQL)

- 简单查询

```mysql
select 字段名1,字段名2,字段名3,...... from 表名;
# 任何一条sql语都以;结尾.
# sql语句不区分大小写
# 字段可以参与数学运算

# 查询结果可以重命名
select ENAME, SAL as '年薪' from EMP;
# 标准的sql语句要求字符串使用单引号括起来,虽然mysql支持双引号,但尽量不要用
# as 关键字可以省略

# 查看表中的所有的字段
# 实际开发不建议使用* 效率比较低
select * from 表名;

```

- 条件查询

```mysql
1.语法格式:
select 
	字段1, 字段2 ...
from
	表名
where 
	条件;

2.关于条件可以使用的运算符
# x between y and 查询在x,y 之间的数据,闭区间,左小右大
SELECT ENAME, JOB, SAL*12 AS '年薪',SAL FROM EMP WHERE SAL BETWEEN 1000 AND 1500;
结果:
+--------+----------+----------+---------+
| ENAME  | JOB      | 年薪     | SAL     |
+--------+----------+----------+---------+
| WARD   | SALESMAN | 15000.00 | 1250.00 |
| MARTIN | SALESMAN | 15000.00 | 1250.00 |
| TURNER | SALESMAN | 18000.00 | 1500.00 |
| ADAMS  | CLERK    | 13200.00 | 1100.00 |
| MILLER | CLERK    | 15600.00 | 1300.00 |
+--------+----------+----------+---------+
# 在数据库表中,NUll 并不是一个值,而代表空,即什么也没有,空不是一个值,不能用等号衡量,必须使用 is null 或者 is not null

3. or 条件 与 and 条件混用的时候
# 优先级 and 比较高
# 在优先级不确定的时候添加小括号确定顺序;

4. 条件 in 的用法
select ename, job, from emp where job = 'SALESMAN' or job = 'MANAGER';
# in 后面的是具体的值而不是一个区间
select ename, job, from emp where job in('SALESMAN', 'MANAGER');
select ename, job, from emp where job not in('SALESMAN', 'MANAGER');

5. like 模糊查询
	
	% 代表任意多个字符, _ 代表任意一个字符
# 查询名字中第二个字母是A的人
SELECT ENAME FROM EMP WHERE ENAME LIKE '_A%';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%\_%';
```

- 排序查询(升降)

```mysql 
1. 语法格式
 # 默认按照sal升序
select
	ename,sal
from 
	emp
order by
	sal asc(desc);
	
# 多个字段同时排序,越靠前的字段优先级大,只有在前面的字段都相等的时候后面的字段才会起作用. 
# order by 是最后执行的

#ORDER BY 后面的字段之间也需要用逗号隔开
SELECT ENAME,SAL FROM EMP ORDER BY SAL,ENAME DESC;
```

- 分组函数(多行处理函数)

> 1. 输入多行 输出一行
> 2. 分组函数是对一组数据进行处理的
>
> 3. **分组函数自动忽略null**
>
> 4. 不可直接出现在where子句中,因为group by 是在where 之后执行的,而且分组函数是在group by执行后执行jishu
>
>    where 执行的时候还没有分组,没有权利执行分组函数,分组函数只能在分完组之后才能使用
>
> 5. 分组函数一般都会和 group by 联合使用(这也是为什么叫分组函数)
>
> 6. 任何一个分组函数都是在 group by 语句执行结束之后执行.

```mysql

sum   求和
avg   取平均
max   取最大的数
min   取最小数
count 计数

 # count(*) count(comm)的区别?
 前者是统计字段出现的总次数,后者是统计字段中不为NUll的元素总数.

---
找出最高工资
select ename, max(sal) from emp;
找出工资总和
找出平均工资
找出总人数
找出工资高于平均工资的员工  
select ename, sal from EMP where sal > avg(sal);# 会报错 无效的使用了分组函数

--- 
分组函数的组合使用:
select ename, count(*), sum(sal),max(sal) from EMP;
```

- 单行处理函数

  > 输入一行, 输出一行

```mysql
#计算每一个员工的工资?
重点: 如果数据库中有null 参与运算,那么结果一定是null,会产生错误
select ename, (sal+comm)*12 as yearsal from emp;
select ename, (sal + ifnull(comm,0) ) * 12 as yearsal from EMP;
ifnull(可能为null的数据, 如果该数据为null如何处理)函数
#
select ename, ifnull(comm, 0) from EMP;	
```

- group by 和 having

> group by : 按照某个字段或者某些字段进行二次过滤
>
> having: 对分组之后的数据,如果不满意,进行再次过滤,并不能单独使用
>
> - having是 group by 的搭档只有在使用了group by 的基础上才能使用hanving
>
> 1.当sql语句中没有 group by 时(实际上有一个缺省的group by),整张表的数据自成一组
>
> 2,当sql语句中含有 group by 的时候,select 后面只能包含参加分组的字段以及分组函数

```mysql
# 找各个工作岗位的最高薪资
select max(SAL) from EMP group by job; # 先对job 中的类别进行分组,再对分组进行求最大值

# 求每一个岗位的平均薪资
SELECT job, avg(sal) from emp group by job;
# 查找薪资高于平均工资的人员
select ename, sal where sal > avg(sal) # 错误案例
select ename, sal from EMP where sal > (select avg(sal) from emp) #子查询

#找出不同部门不同岗位的最高薪资 
select deptno, job, max(sal) from emp group by depthno, job;
#找出每一个部门的最高薪资,要求显示薪资大于2500的数据
1.第一步,先找出每个部门的最高薪资
select deptno, max(sal) from EMP group by  depthno;

select deptno, max(sal) from EMP group by  depthno having max(sal)>2900;
select deptno, max(sal) from EMP where sal>2900 group by  depthno;# 效率较高

#找出每个部门平均薪资,并显示大于2000
select deptno avg(sal) from emp group by deptno having avg(sal)>2000;
```

- DQL语句的顺序

  ```mysql
  select 			5.选择
  	..
  from			1.表询表
  	..			
  where			2.条件过滤
  	..
  group by 		3.分组
  	..
  having			4.再次筛选
  	..
  order by		6.排序输出
  	..
  ```

  - 查询结果去重

  ```mysql
  SELECT distinct deptno job from EMP； # job 和deptno 联合去重
  # 案例l: 统计岗位的数量
  select count(distinct job) from EMP;
  
  ```

  

  