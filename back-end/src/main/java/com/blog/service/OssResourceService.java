package com.blog.service;

import com.blog.entity.oss.OssResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 云存储资源表 服务类
 * </p>
 *
 * @author bobbi
 * @since 2018-11-30
 */
public interface OssResourceService {

    OssResource upload(MultipartFile file);
}
