package com.atguigu.eduService.controller;

import com.atguigu.commonUtils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin //解决跨域
public class EduLoginController {
    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604400138867&di=558bd2cfe665768c566f28f796522e16&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F70%2F91%2F01300000261284122542917592865.jpg");
    }
}
