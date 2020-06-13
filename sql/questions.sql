

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