package com.yjy.mapper;

import com.yjy.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
//    改用了PageHelper插件
//    @Select("select count(*) from emp")
//    public Long count();


//    @Select("select *from emp limit #{start},#{pageSize}")
//    改用了xml映射文件的形式，因为是sql动态查询，即条件可以为空
    public List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp (username, name, gender, image, job, " +
            "entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}," +
            "#{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void add(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")

    Emp getByUsernameAndPasswrod(Emp emp);

    /**
     * 根据部门id删除部门下员工
     * @param deptId
     */
    @Delete("DELETE from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
