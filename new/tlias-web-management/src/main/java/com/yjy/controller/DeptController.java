package com.yjy.controller;

import com.yjy.pojo.Dept;
import com.yjy.pojo.Result;
import com.yjy.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        log.info("查询所有部门");
        List<Dept> deptList =deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除部门:{}",id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        log.info("增加部门:{}",dept);
        deptService.add(dept);
        return Result.success();
    }
}
