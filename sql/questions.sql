

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
