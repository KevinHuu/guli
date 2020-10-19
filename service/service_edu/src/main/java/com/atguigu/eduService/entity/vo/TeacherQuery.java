package com.atguigu.eduService.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("教师查询")
@Data
public class TeacherQuery {

    @ApiModelProperty("教师名称，模糊查询")
    private String name;
    @ApiModelProperty("教师头衔：1:高级讲师 2:首席讲师")
    private Integer level;
    @ApiModelProperty(value = "查询开始时间",example = "2020-01-01 00:00:00")
    private String begin;
    @ApiModelProperty(value = "查询结束时间",example = "2020-01-01 00:00:00")
    private String end;
}
