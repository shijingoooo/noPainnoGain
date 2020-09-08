package com.shijing.nopainnogain.spring.jpa;

/**
 * @description:
 * @author: shijing
 * @create: 2020-04-25 18:19
 **/
public class TestRepository {

    /**
     * 1. Repository是一个空接口，即是一个标记接口
     * 2. 若我们定义的接口继承了Repository，则该接口会被IOC容器识别为一个Repository Bean.
     * 纳入到IOC容器中，进而可以在该接口中定义满足一定规范的方法。
     * 3. 实际上，也可以通过 @RepositoryDefinition注解来替代继承Repository接口
     *
     * Repository的子接口
     * CrudRepository继承Repository实现了一组CRUD相关的方法
     * PagingAndSortingRepository继承了CrudRepository，实现了一组分页排序相关的方法
     * JpaRepository继承PagingAndSortingRepository，实现了一组JPA规范相关的方法
     * 自定义的xxxRepository需要继承JpaRepository，这样的接口就具备了通用的数据访问控制层的能力
     * JpaSpecificationExecutor不属于Repository体系，实现一组JPACriteria查询相关方法
     *
     * 在Repository子接口中声明方法
     * 1. 简单条件查询：查询某一个实体类或者集合
     * 按照Spring Data的规范，查询方法以find|read|get开头，
     * 涉及条件查询时，条件的属性用条件关键字连接，要注意的是：
     * 条件属性以首字母大写
     * 2. 支持属性的级联查询，若当前类有符合条件的属性，则优先使用，而不使用级联属性。
     * 若需要使用级联属性，则属性之间使用_进行连接
     * 例如：定义一个Entity实体类
     * class User{
     *     private String firstName;
     *     private String lastName;
     * }
     * 使用And条件连接时，应这样写：
     * findByLastNameAndFirstName(String lastName, String firstName);
     * 条件的属性名称与个数要与参数的位置与个数一一对应
     *
     * 使用@Query注解可以自定义JPQL语句实现更灵活的查询
     * 为Query注解传递参数的方式
     * 1. 使用占位符 "SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2"
     * 2. 命名参数的方式
     * @Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
     * List<Person> test(@Param("email") String email, @Param("lastName") String lastName);
     * 3. SpringData 允许在占位符上添加 %%
     * 4. 设置nativeQuery=true 使用原生SQL查询
     * @Query(value="SELECT count(id) FROM Person", nativeQuery=true)
     *
     *
     * 可以通过自定义的JPQL完成UPDATE和DELETE操作，注意：JPQL不支持使用INSERT
     * 在@Query注解中编写JPQL语句，但必须使用@Modify进行修饰，以通知SpringData
     * 这是一个UPDATE或DELETE操作
     * UPDATE或DELETE操作需要使用事务，此时需要定义Service层，在Service层的方法上添加事务操作
     * 默认情况下，SpringData的每个方法上有事务，但都是一个只读事务，他们不能完成修改操作
     * @Modifying
     * @Query("UPDATE Person p SET p.email = email WHERE id = :id")
     *
     *
     * 目标: 实现带查询条件的分页. id > 5 的条件
     *
     * 调用JpaSpecificationExecutor的 Page<T> findAll(Specification<T> spec, Pageable pageable);
     * Specification: 封装了 JPA Criteria 查询的查询条件
     * Pageable: 封装了请求分页的信息: 例如 pageNo, pageSize, Sort
     *
     * // 通常使用 Specification 的匿名内部类
     * Specification<Person> specification = new Specification<Person>() {
     *      /**
     *      * @param root: 代表查询的实体类
     *      * @param query: 可以从中得到Root对象，即告知JPA Criteria 查询要查询哪一个实体类，还可以
     *      * 来添加查询条件, 还可以结合EntityManager对象得到最终查询的TypedQuery对象.
     *      * @param cb: CriteriaBuilder对象, 用于创建Criteria相关对象工厂, 当然可以从中获取到 Predicate 对象
     *      * @return: *Predicate 类型, 代表一个查询条件.
     *      @Override
     *      public Predicate toPredicate(Root<Person> root,
     *              CriteriaQuery<?> query, CriteriaBuilder cb) {
     *          Path path = root.get("id");
     *          Predicate predicate = cb.gt(path, 5);
     *          return predicate;
     *      }
     */
}
