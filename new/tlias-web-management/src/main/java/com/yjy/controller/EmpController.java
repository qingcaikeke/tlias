package com.yjy.controller;

import com.yjy.pojo.Emp;
import com.yjy.pojo.PageBean;
import com.yjy.pojo.Result;
import com.yjy.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询，参数：{},{}",page,pageSize);
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){

        log.info("批量删除，ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }


    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.add(emp);
        return Result.success();
    }
}
