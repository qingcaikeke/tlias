package com.yjy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yjy.mapper.EmpMapper;
import com.yjy.pojo.Emp;
import com.yjy.pojo.PageBean;
import com.yjy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//        Long count = empMapper.count();
//        List<Emp> empList = empMapper.page((page-1)*pageSize,pageSize);
//        PageBean pageBean = new PageBean(count,empList);
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.page(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>)empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPasswrod(emp);
    }
}
