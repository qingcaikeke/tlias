package com.yjy.service;

import com.yjy.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    //查询全部部门
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);
}
