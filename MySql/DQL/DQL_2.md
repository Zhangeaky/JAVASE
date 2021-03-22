## 连接查询

### 什么是连接查询？

```
    在实际的开发中，大部分情况都不是从单表中查询数据，一般都是多张表联合查询数据取出最终的结果，在实际开发中一般一个业务会对应多张表，防止数据的冗余。
```

### 连接查询的分类

- 根据表的连接方式：

  - 内连接：

    ```mysql
    什么是内连接？
    1. 假设A表和B表使用内连接进行连接，凡是A表和B表能够匹配上的记录全都查询出来。
    2. 如果不能匹配则不会显示。
    ```
  3. A，B两张表没有主副之分，两张表是平等的；
  ```
  
  - 等值连接：
  
    ```mysql
    条件是等量关系：
    	# 案例 查询每一个员工的部门名称，要求显示部门名和员工名
  ```
  
  - 非等值连接
  
    ```mysql
  连接条件是非等值关系：
    	#案例： 找出每一个员工的工资等级，并要求显示员工名，工资，工资等级
    	SELECT 
    		E.ENAME, E.SAL, S.GRADE 
    	FROM 
    		EMP E 
    	INNER JOIN 
    		SALGRADE S 
    	ON 
    		E.SAL BETWEEN S.LOSAL AND S.HISAL;
    	
    +--------+---------+-------+
    | ENAME  | SAL     | GRADE |
    +--------+---------+-------+
    | SMITH  |  800.00 |     1 |
    | ALLEN  | 1600.00 |     3 |
    | WARD   | 1250.00 |     2 |
    | JONES  | 2975.00 |     4 |
    | MARTIN | 1250.00 |     2 |
    | BLAKE  | 2850.00 |     4 |
    | CLARK  | 2450.00 |     4 |
    | SCOTT  | 3000.00 |     4 |
    | KING   | 5000.00 |     5 |
    | TURNER | 1500.00 |     3 |
    | ADAMS  | 1100.00 |     1 |
    | JAMES  |  950.00 |     1 |
    | FORD   | 3000.00 |     4 |
    | MILLER | 1300.00 |     2 |
    +--------+---------+-------+
    ```
  
  - 自连接
  
    ```mysql
  最大的特点是：一张表看做两张表 自己连接自己
    # 案例 找出每一个员工的上级领导，要求显示员工名和对应领导名
    SELECT 
    	A.ENAME AS '员工名', B.ENAME AS '领导名' 
    FROM 
    	EMP A 
    INNER JOIN 
    	EMP B 
    ON 
    	A.MGR = B.EMPNO; 
    # 员工表
    +--------+------+-------+
    | ename  | mgr  | empno |
    +--------+------+-------+
    | SMITH  | 7902 |  7369 |
    | ALLEN  | 7698 |  7499 |
    | WARD   | 7698 |  7521 |
    | JONES  | 7839 |  7566 |
    | MARTIN | 7698 |  7654 |
    | BLAKE  | 7839 |  7698 |
    | CLARK  | 7839 |  7782 |
    | SCOTT  | 7566 |  7788 |
    | KING   | NULL |  7839 |
    | TURNER | 7698 |  7844 |
    | ADAMS  | 7788 |  7876 |
    | JAMES  | 7698 |  7900 |
    | FORD   | 7566 |  7902 |
    | MILLER | 7782 |  7934 |
    +--------+------+-------+
    
    +--------+------+-------+
    | ename  | mgr  | empno |
    +--------+------+-------+
    | SMITH  | 7902 |  7369 |
    | ALLEN  | 7698 |  7499 |
    | WARD   | 7698 |  7521 |
    | JONES  | 7839 |  7566 |
    | MARTIN | 7698 |  7654 |
    | BLAKE  | 7839 |  7698 |
    | CLARK  | 7839 |  7782 |
    | SCOTT  | 7566 |  7788 |
    | KING   | NULL |  7839 |
    | TURNER | 7698 |  7844 |
    | ADAMS  | 7788 |  7876 |
    | JAMES  | 7698 |  7900 |
    | FORD   | 7566 |  7902 |
    | MILLER | 7782 |  7934 |
    +--------+------+-------+
    ```
  
  - 外连接：
  
  ```mysql
    什么是外连接？
  假设A表和B表进行连接，使用外链接的话，AB两张表中有一张是主表，一张是副表，主要查询主表中的数据，捎带查询附表中的数据，当副表中的数据没有和主表中的匹配上，副表会自动模拟出null与之匹配；
    
  特点：主表数据无条件全部查询出来
  ```
  
    - 左外连接
  
    ```mysql
    左边的表是主表，有对应右连接的写法
  # 案例 找出每一个员工的上级领导，要求显示员工名和对应领导名
    
  SELECT 
    	A.ENAME AS '员工名', B.ENAME AS '领导名' 
    FROM 
    	EMP A 
    LEFT OUTER JOIN   #左边的表是主表，即A.ENAME 无论能否匹配到都要显示出来，模拟出null，数据不能丢失
    	EMP B 
    ON 
    	A.MGR = B.EMPNO; 
    ```
  
    - 右外连接
  
    ```mysql
    右边的表是主表，有对应左连接的写法
  SELECT 
    	A.ENAME AS '员工名', B.ENAME AS '领导名' 
  FROM 
    	EMP B
    RIGHT OUTER JOIN  #左边的表是主表，即A.ENAME 无论能否匹配到都要显示出来，模拟出null，数据不能丢失
    	EMP A
    ON 
    	A.MGR = B.EMPNO; 
    ```
  
    ```mysql
    # 案例
    #找出哪一个部门没有员工？
  ```
  
    *内连接与外连接的区分点是sql语句中有没有 LEFT 和 RIGHT*
  
- 全连接
  
    ```
  
    
    
    
    ```

### 笛卡尔积现象

> 表的别名好处：
>
> 1. 执行效率高
> 2. 可读性好
>
> 表的连接查询原理是：A表与B表连接的时候，*A表中的其中一条记录与B表中的所有记录都匹配*
>
> 如何避免：**加条件过滤**，但是避免了笛卡尔积的现象并不会减少记录的底层匹配次数，只不过显示的时候，只显示有效记录

```mysql
# 案例：找出每一个员工的部门名称，要求显示员工名和部门名
EMP表
+--------+--------+
| ENAME  | DEPTNO |
+--------+--------+
| SMITH  |     20 |
| ALLEN  |     30 |
| WARD   |     30 |
| JONES  |     20 |
| MARTIN |     30 |
| BLAKE  |     30 |
| CLARK  |     10 |
| SCOTT  |     20 |
| KING   |     10 |
| TURNER |     30 |
| ADAMS  |     20 |
| JAMES  |     30 |
| FORD   |     20 |
| MILLER |     10 |
+--------+--------+

DEPTNO表
+--------+------------+----------+
| DEPTNO | DNAME      | LOC      |
+--------+------------+----------+
|     10 | ACCOUNTING | NEW YORK |
|     20 | RESEARCH   | DALLAS   |
|     30 | SALES      | CHICAGO  |
|     40 | OPERATIONS | BOSTON   |
+--------+------------+----------+
# 笛卡尔乘积现象：
#   如果两张表连接查询时,没有任何条件限制结果会是两张表中的记录乘积；
#   select 后面的字段如果写在一起用逗号隔开说明要联合显示，粘在一块
select e.ename, d.dname from emp e,dept d;
+--------+------------+
| ename  | dname      |
+--------+------------+
| SMITH  | ACCOUNTING |
| SMITH  | RESEARCH   |
| SMITH  | SALES      |
| SMITH  | OPERATIONS |
| ALLEN  | ACCOUNTING |
| ALLEN  | RESEARCH   |
| ALLEN  | SALES      |
.......................
select e.ename, d.dname from emp e,dept d where e.depth = d.depth;//SQL92

+--------+------------+
| ENAME  | DNAME      |
+--------+------------+
| SMITH  | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| JONES  | RESEARCH   |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| CLARK  | ACCOUNTING |
| SCOTT  | RESEARCH   |
| KING   | ACCOUNTING |
| TURNER | SALES      |
| ADAMS  | RESEARCH   |
| JAMES  | SALES      |
| FORD   | RESEARCH   |
| MILLER | ACCOUNTING |
+--------+------------+
SQL99写法：
select 
	e.ename, d.dname 
from 
	emp e 
inner join 
# inner 可以省略 可读性好
	dept d 
on 
	e.depth = d.depth;  //SQL92
	
语法： 
	A join B on {连接条件} where {过滤条件}
	# 将表连接的条件与数据整合后的过滤分开，结构更加清晰


```

### 三张表及以上的连接

```mysql
# 以下的语句表示A表和B表先进行连接，连接之后再继续和C表进行连接
A JOIN B ON ... JOIN C ON ...

# 案例：
# 找出每一个员工的部门名称和工资等级
SELECT 
E.ENAME,E.DEPTNO, D.DNAME,S.GRADE  
FROM  
EMP E 
JOIN DEPT D ON E.DEPTNO = D.DEPTNO 
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL;

# 案例:
# 找出每一个员工的部门名称、工资等级、以及上级领导

SELECT 
E.ENAME '员工',E.DEPTNO, D.DNAME,S.GRADE  ,E_.ENAME '领导'
FROM  
EMP E 
JOIN DEPT D ON E.DEPTNO = D.DEPTNO 
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
LEFT JOIN EMP E_ ON E.MGR E_.EMPNO;

```

*Navicat工具的使用*

## 子查询

### 什么是子查询？子查询可以出现在哪里？

```mysql
解释：在 SELECT 语句中嵌套 SELECT 语句
# 
SELECT
	...(SELECT)
FROM 
	...(SELECT)
WHERE
	...(SELECT)
```



### 在WHERE 中使用子查询

```mysql
# 案例：找出高于平均薪资员工的信息

```

### 在FROM中使用子查询（十分重要）

> from后面只能跟表，但也可以是一个sql语句

```mysql
# 案例：找出每个部门平均薪资的薪资等级
第一步：找出每一个部门的平均薪水
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;
+--------+-------------+
| DEPTNO | AVG(SAL)    |
+--------+-------------+
|     10 | 2916.666667 |
|     20 | 2175.000000 |
|     30 | 1566.666667 |
+--------+-------------+

第二步：将以上结果作为临时表t，让t表与salgrade表连接，并找出连接 条件

SELECT T.*, S.GRADE FROM (SELECT DEPTNO,AVG(SAL) '平均薪资' FROM EMP GROUP BY DEPTNO) T JOIN SALGRADE S ON T.平均薪资 BETWEEN S.LOSAL AND S.HISAL;

+--------+--------------+-------+
| DEPTNO | 平均薪资     | GRADE |
+--------+--------------+-------+
|     10 |  2916.666667 |     4 |
|     20 |  2175.000000 |     4 |
|     30 |  1566.666667 |     3 |
+--------+--------------+-------+

# 案例：
# 查询找出每个部门平均的薪水等级
第一步：找出每一个员工的薪水等级
SELECT E.ENAME, E.DEPTNO, S.GRADE FROM EMP E JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL;
+--------+--------+-------+
| ENAME  | DEPTNO | GRADE |
+--------+--------+-------+
| SMITH  |     20 |     1 |
| ALLEN  |     30 |     3 |
| WARD   |     30 |     2 |
| JONES  |     20 |     4 |
| MARTIN |     30 |     2 |
| BLAKE  |     30 |     4 |
| CLARK  |     10 |     4 |
| SCOTT  |     20 |     4 |
| KING   |     10 |     5 |
| TURNER |     30 |     3 |
| ADAMS  |     20 |     1 |
| JAMES  |     30 |     1 |
| FORD   |     20 |     4 |
| MILLER |     10 |     2 |
+--------+--------+-------+

第二步：按照deptno字段分组，求grade的平均值
SELECT E.DEPTNO, AVG(S.GRADE) FROM EMP E JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL GROUP BY E.DEPTNO;

+--------+--------------+
| DEPTNO | AVG(S.GRADE) |
+--------+--------------+
|     10 |       3.6667 |
|     20 |       2.8000 |
|     30 |       2.5000 |
+--------+--------------+
```

### 在SELECT后面使用子查询

```mysql
# 案例：
# 找出每个员工所在的部门名称，要求显示员工名和部门名
SELECT E.ENAME,(SELECT D.DNAME FROM DEPT D WHERE E.DEPTNO = D.DEPTNO) AS DNAME FROM EMP;
```

### UNION（可以将查询结果集相加）

```mysql
# 案例：
# 找出工作岗位是SALESMAN和MANAGER的员工？
第一种：and
第二种：in ()
第三种：
SELECT ENAME,JOB FROM EMP WHERE JOB = 'SALESMAN'
UNION
SELECT ENAME,JOB FROM EMP WHERE JOB = 'MANAGER'

# 注意点
# 使用union连接的多次查询的列的数量一定要一样

```

## limit使用（重点中的重点）

### limit相关

> 1. mysql特有，其他数据库没有的，并不通用，oracle中有一个相同的机制叫做rownum
>
> 2. limit取结果集中的部分数据，这是他的作用
>
> 3. 语法机制：
>     limit startIndex, length
>     startIndex:表示起始位置， startindex从0开始，0表示第一条数据
>     length:表示取几个
>
> 4. 是sql语句执行的最后环节
>
> 5. 分页sql
>
>   limit  (pageNo - 1) * pageSize, pageSize
>
>    

```mysql
# 案例
# 取出工资前五名
SELECT ENAME，SAL FROM EMP ORDER BY SAL DESC LIMIT 0, 5;
SELECT ENAME，SAL FROM EMP ORDER BY SAL DESC LIMIT 5; #省略0

# 案例
# 找出工资早第4-9名的员工；

#
```

