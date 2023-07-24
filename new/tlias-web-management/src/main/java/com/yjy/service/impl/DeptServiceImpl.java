package com.yjy.service.impl;

import com.yjy.mapper.DeptMapper;
import com.yjy.mapper.EmpMapper;
import com.yjy.pojo.Dept;
import com.yjy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//将当前方法交给spring进行事物管理
    public void delete(Integer id) {

        deptMapper.delete(id);
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
}
