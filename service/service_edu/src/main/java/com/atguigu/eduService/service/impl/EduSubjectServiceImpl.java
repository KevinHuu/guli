package com.atguigu.eduService.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduService.entity.EduSubject;
import com.atguigu.eduService.entity.excel.SubjectData;
import com.atguigu.eduService.listener.SubjectExcelListener;
import com.atguigu.eduService.mapper.EduSubjectMapper;
import com.atguigu.eduService.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2021-01-13
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Autowired
    private SubjectExcelListener listener;

    @Override
    public void saveSubject(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), SubjectData.class,listener).sheet(0).doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
