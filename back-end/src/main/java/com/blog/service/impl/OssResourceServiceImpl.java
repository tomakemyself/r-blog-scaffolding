package com.blog.service.impl;

import com.blog.common.constants.OssConstants;
import com.blog.common.util.UUIDUtils;
import com.blog.entity.oss.OssResource;
import com.blog.service.OssResourceService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 云存储资源表 服务实现类
 * </p>
 *
 * @author bobbi
 * @since 2018-11-30
 */
@Service
public class OssResourceServiceImpl implements OssResourceService {

    @Override
    public OssResource upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newName = UUIDUtils.getUUID() + fileName.substring(fileName.lastIndexOf("."));
        File dest = new File(OssConstants.UPLOAD_PREFIX + newName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 赋予读写权限 这是undertow服务器的一个坑
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.OTHERS_READ);
        try {
            Files.setPosixFilePermissions(Paths.get(OssConstants.UPLOAD_PREFIX + newName), perms);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new OssResource(OssConstants.SHOW_PREFIX + newName, newName);
    }
}
