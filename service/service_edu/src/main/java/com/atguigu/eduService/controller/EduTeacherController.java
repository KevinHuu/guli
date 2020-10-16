package com.atguigu.eduService.controller;


import com.atguigu.eduService.entity.EduTeacher;
import com.atguigu.eduService.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/eduService/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher(){
        return teacherService.list(null);
    }

    @ApiOperation("逻辑删除讲师")
    @PostMapping("{id}")
    public boolean removeTeacherById(@PathVariable String id){
        return teacherService.removeById(id);
    }
}

