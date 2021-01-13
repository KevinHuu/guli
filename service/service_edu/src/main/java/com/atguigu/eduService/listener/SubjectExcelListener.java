package com.atguigu.eduService.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.atguigu.eduService.entity.EduSubject;
import com.atguigu.eduService.entity.excel.SubjectData;
import com.atguigu.eduService.service.EduSubjectService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    @Autowired
    private EduSubjectService subjectService;

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context){

    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData==null) {
            throw new GuliException(20001, "Excel数据为空");
        }
        EduSubject one = existOneSubject(subjectData.getOneSubjectName());
        if(one==null){
            one = new EduSubject();
            one.setParentId("0");
            one.setTitle(subjectData.getOneSubjectName());
            subjectService.save(one);
        }
        String pid = one.getId();
        EduSubject two = existTwoSubject(subjectData.getTwoSubjectName(), pid);
        if(two==null){
            two = new EduSubject();
            two.setParentId(pid);
            two.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(two);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    private EduSubject existOneSubject(String name){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject one = subjectService.getOne(wrapper);
        return one;
    }

    private EduSubject existTwoSubject(String name,String parentId){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",parentId);
        EduSubject two = subjectService.getOne(wrapper);
        return two;
    }
}
