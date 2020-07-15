

-- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
--
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+
-- 解题思路
-- IFNULL(expression, alt_value)
-- 如果第一个参数的表达式 expression 为 NULL，则返回第二个参数的备用值(此题中是返回null)。
-- expression是table的时候要加括号
--
-- distinct：
-- 去重一样的Salary
--
-- limit：限时返回的个数
-- offset：跳过几个
-- limit 1 offset 1:返回一个结果，跳过一个
-- 例如返回第三高就是：limit 1 offset 2

select IFNULL(
  (SELECT distinct Salary from Employee order by Salary desc limit 1 offset 1),NULL)
   as SecondHighestSalary

-- 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id 是这个表的主键。
-- 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+

-- 方法一：DELETE + 子查询，实测效率更高
DELETE FROM Person
WHERE Id NOT IN (   -- 删除不在查询结果中的值
    SELECT id FROM
   (
       SELECT MIN(Id) AS Id -- 排除Email相同时中Id较大的行
       FROM Person
       GROUP BY Email
   ) AS temp    -- 此处需使用临时表，否则会发生报错
)

-- 方法二：官方题解，DELETE + 自连接
DELETE P1
FROM Person P1, Person P2
WHERE P1.Email = P2.Email   -- 利用where进行自连接
AND P1.Id > P2.Id   -- 选择Id较大的行

-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
--
-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | 200                    |
-- +------------------------+

-- 方法一
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N := N-1;
  RETURN (
    SELECT Salary
    FROM Employee
    GROUP BY Salary
    ORDER BY Salary DESC
    LIMIT N,1
  );
END

-- 编写一个 SQL 查询来实现分数排名。
--
-- 如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
--
-- +----+-------+
-- | Id | Score |
-- +----+-------+
-- | 1  | 3.50  |
-- | 2  | 3.65  |
-- | 3  | 4.00  |
-- | 4  | 3.85  |
-- | 5  | 4.00  |
-- | 6  | 3.65  |
-- +----+-------+
-- 例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：
--
-- +-------+------+
-- | Score | Rank |
-- +-------+------+
-- | 4.00  | 1    |
-- | 4.00  | 1    |
-- | 3.85  | 2    |
-- | 3.65  | 3    |
-- | 3.65  | 3    |
-- | 3.50  | 4    |
-- +-------+------+
--
-- dense_rank()的排名是1，1，2，3，4
-- rank()是1，1，3，4，5
-- row_number是1，2，3，4，5

SELECT Score,
DENSE_RANK()OVER(ORDER BY Score DESC) as 'Rank'
FROM Scores

-- Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。
--
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 85000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- | 5  | Janet | 69000  | 1            |
-- | 6  | Randy | 85000  | 1            |
-- | 7  | Will  | 70000  | 1            |
-- +----+-------+--------+--------------+
-- Department 表包含公司所有部门的信息。
--
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- 编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。例如，根据上述给定的表，查询结果应返回：
--
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | IT         | Randy    | 85000  |
-- | IT         | Joe      | 85000  |
-- | IT         | Will     | 70000  |
-- | Sales      | Henry    | 80000  |
-- | Sales      | Sam      | 60000  |
-- +------------+----------+--------+
-- 解释：
--
-- IT 部门中，Max 获得了最高的工资，Randy 和 Joe 都拿到了第二高的工资，Will 的工资排第三。销售部门（Sales）只有两名员工，Henry 的工资最高，Sam 的工资排第二。

SELECT d.Name AS `Department`, e1.Name AS Employee, e1.Salary
FROM Employee e1, Department d
WHERE
e1.DepartmentId = d.Id AND
3 > (
    SELECT COUNT(distinct Salary)
    FROM Employee e2
    WHERE e2.Salary > e1.Salary
    AND e2.DepartmentId = e1.DepartmentId
)

-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
--
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- 例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
--
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- #①首先遍历一遍整张表，找出每个数字的连续重复次数
-- #具体方法为：
--     #初始化两个变量，一个为pre，记录上一个数字；一个为count，记录上一个数字已经连续出现的次数。
--     #然后调用if()函数，如果pre和当前行数字相同，count加1极为连续出现的次数；如果不同，意味着重新开始一个数字，count重新从1开始。
--     #最后，将当前的Num数字赋值给pre，开始下一行扫描。
--     select
--         Num,    #当前的Num 数字
--         if(@pre=Num,@count := @count+1,@count := 1) as nums, #判断 和 计数
--         @pre:=Num   #将当前Num赋值给pre
--     from Logs as l ,
--         (select @pre:= null,@count:=1) as pc #这里需要别名
--     #上面这段代码执行结果就是一张三列为Num,count as nums,pre的表。
--
-- #②将上面表的结果中，重复次数大于等于3的数字选出，再去重即为连续至少出现三次的数字。
--     select
--         distinct Num as ConsecutiveNums
--     from
--         (select Num,
--                 if(@pre=Num,@count := @count+1,@count := 1) as nums,
--                 @pre:=Num
--             from Logs as l ,
--                 (select @pre:= null,@count:=1) as pc
--         ) as n
--     where nums >=3;

-- 方法：用 DISTINCT 和 WHERE 语句
-- 算法
--
-- 连续出现的意味着相同数字的 Id 是连着的，由于这题问的是至少连续出现 3 次，我们使用 Logs 并检查是否有 3 个连续的相同数字。
--
--
SELECT *
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
-- Id	Num	Id	Num	Id	Num
-- 1	1	2	1	3	1
-- 注意：前两列来自 l1 ，接下来两列来自 l2 ，最后两列来自 l3 。
--
-- 然后我们从上表中选择任意的 Num 获得想要的答案。同时我们需要添加关键字 DISTINCT ，因为如果一个数字连续出现超过 3 次，会返回重复元素。
--
-- MySQL
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num

-- Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
--
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 70000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- +----+-------+--------+--------------+
-- Department 表包含公司所有部门的信息。
--
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- 编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
--
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | Sales      | Henry    | 80000  |
-- +------------+----------+--------+

SELECT d.Name AS Department, e.Name AS Employee, e.Salary AS Salary
FROM Department d, Employee e
WHERE d.Id = e.DepartmentId
AND (e.Salary, e.DepartmentId) IN
(
  SELECT MAX(Salary) AS Salary,DepartmentId
  FROM Employee
  GROUP BY DepartmentId
)

-- 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
--
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
-- 例如，根据上述给定的 Weather 表格，返回如下 Id:
--
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+
SELECT w1.Id
FROM Weather w1 JOIN Weather w2
ON DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
AND w1.Temperature > w2.Temperature

-- 给定一个 salary 表，如下所示，有 m = 男性 和 f = 女性 的值。交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求只使用一个更新（Update）语句，并且没有中间的临时表。
--
-- 注意，您必只能写一个 Update 语句，请不要编写任何 Select 语句。
--
-- 例如：
--
-- | id | name | sex | salary |
-- |----|------|-----|--------|
-- | 1  | A    | m   | 2500   |
-- | 2  | B    | f   | 1500   |
-- | 3  | C    | m   | 5500   |
-- | 4  | D    | f   | 500    |
-- 运行你所编写的更新语句之后，将会得到以下表:
--
-- | id | name | sex | salary |
-- |----|------|-----|--------|
-- | 1  | A    | f   | 2500   |
-- | 2  | B    | m   | 1500   |
-- | 3  | C    | f   | 5500   |
-- | 4  | D    | m   | 500    |

UPDATE Salary SET sex = CASE sex WHEN 'm' THEN 'f' ELSE 'm' END ;

-- Trips 表中存所有出租车的行程信息。每段行程有唯一键 Id，Client_Id 和 Driver_Id 是 Users 表中 Users_Id 的外键。Status 是枚举类型，枚举成员为 (‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’)。
--
-- +----+-----------+-----------+---------+--------------------+----------+
-- | Id | Client_Id | Driver_Id | City_Id |        Status      |Request_at|
-- +----+-----------+-----------+---------+--------------------+----------+
-- | 1  |     1     |    10     |    1    |     completed      |2013-10-01|
-- | 2  |     2     |    11     |    1    | cancelled_by_driver|2013-10-01|
-- | 3  |     3     |    12     |    6    |     completed      |2013-10-01|
-- | 4  |     4     |    13     |    6    | cancelled_by_client|2013-10-01|
-- | 5  |     1     |    10     |    1    |     completed      |2013-10-02|
-- | 6  |     2     |    11     |    6    |     completed      |2013-10-02|
-- | 7  |     3     |    12     |    6    |     completed      |2013-10-02|
-- | 8  |     2     |    12     |    12   |     completed      |2013-10-03|
-- | 9  |     3     |    10     |    12   |     completed      |2013-10-03|
-- | 10 |     4     |    13     |    12   | cancelled_by_driver|2013-10-03|
-- +----+-----------+-----------+---------+--------------------+----------+
-- Users 表存所有用户。每个用户有唯一键 Users_Id。Banned 表示这个用户是否被禁止，Role 则是一个表示（‘client’, ‘driver’, ‘partner’）的枚举类型。
--
-- +----------+--------+--------+
-- | Users_Id | Banned |  Role  |
-- +----------+--------+--------+
-- |    1     |   No   | client |
-- |    2     |   Yes  | client |
-- |    3     |   No   | client |
-- |    4     |   No   | client |
-- |    10    |   No   | driver |
-- |    11    |   No   | driver |
-- |    12    |   No   | driver |
-- |    13    |   No   | driver |
-- +----------+--------+--------+
-- 写一段 SQL 语句查出 2013年10月1日 至 2013年10月3日 期间非禁止用户的取消率。基于上表，你的 SQL 语句应返回如下结果，取消率（Cancellation Rate）保留两位小数。
--
-- 取消率的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量) / (非禁止用户生成的订单总数)
--
-- +------------+-------------------+
-- |     Day    | Cancellation Rate |
-- +------------+-------------------+
-- | 2013-10-01 |       0.33        |
-- | 2013-10-02 |       0.00        |
-- | 2013-10-03 |       0.50        |
-- +------------+-------------------+

-- 考察round(n,m)函数用法，将n四舍五入到m
-- 考察avg(), 如果是枚举值则返回枚举值索引值的平均值 查看索引值SQL: SELECT val + 0 FROM test;(val是枚举值字段)
-- 若条件如题(限定某些枚举值),则返回限定枚举值的百分比即 (限定枚举值的记录数)/(总记录数)

SELECT
    request_at as 'Day', round(avg(Status!='completed'), 2) as 'Cancellation Rate'
FROM
    trips t JOIN users u1 ON (t.client_id = u1.users_id AND u1.banned = 'No')
    JOIN users u2 ON (t.driver_id = u2.users_id AND u2.banned = 'No')
WHERE
    request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY
    request_at

-- X 市建了一个新的体育馆，每日人流量信息被记录在这三列信息中：序号 (id)、日期 (visit_date)、 人流量 (people)。
--
-- 请编写一个查询语句，找出人流量的高峰期。高峰期时，至少连续三行记录中的人流量不少于100。
--
-- 例如，表 stadium：
--
-- +------+------------+-----------+
-- | id   | visit_date | people    |
-- +------+------------+-----------+
-- | 1    | 2017-01-01 | 10        |
-- | 2    | 2017-01-02 | 109       |
-- | 3    | 2017-01-03 | 150       |
-- | 4    | 2017-01-04 | 99        |
-- | 5    | 2017-01-05 | 145       |
-- | 6    | 2017-01-06 | 1455      |
-- | 7    | 2017-01-07 | 199       |
-- | 8    | 2017-01-08 | 188       |
-- +------+------------+-----------+
-- 对于上面的示例数据，输出为：
--
-- +------+------------+-----------+
-- | id   | visit_date | people    |
-- +------+------------+-----------+
-- | 5    | 2017-01-05 | 145       |
-- | 6    | 2017-01-06 | 1455      |
-- | 7    | 2017-01-07 | 199       |
-- | 8    | 2017-01-08 | 188       |
-- +------+------------+-----------+
SELECT DISTINCT s1.*
FROM stadium s1, stadium s2, stadium s3
WHERE (
    (s1.id = s2.id - 1 AND s2.id = s3.id - 1 AND s1.id = s3.id -2)
  OR (s2.id = s3.id -1 AND s3.id = s1.id - 1 AND s2.id = s1.id - 2)
  OR (s3.id = s1.id -1 AND s1.id = s2.id - 1 AND s3.id = s2.id -2)
) AND s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100
ORDER BY s1.id