package com.atguigu.eduService.service;

import com.atguigu.eduService.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Kevin
 * @since 2021-01-13
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file);
}
