package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.common.util.PageUtils;
import com.blog.entity.operation.Link;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 友链 服务类
 * </p>
 *
 * @author bobbi
 * @since 2019-02-14
 */
public interface LinkService extends IService<Link> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);


    /**
     * 获取link列表
     *
     * @return
     */
    List<Link> listLink();
}
