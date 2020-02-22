package com.blog.controller.portal;

import com.blog.common.Result;
import com.blog.common.constants.RedisCacheNames;
import com.blog.entity.operation.Link;
import com.blog.service.LinkService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LinkController
 *
 * @author bobbi
 * @date 2019/02/21 17:09
 * @email 571002217@qq.com
 * @description
 */
@RequestMapping("/operation")
@CacheConfig(cacheNames = RedisCacheNames.LINK)
@RestController("LinkPortalController")
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping("/links")
    @Cacheable
    public Result listLink() {
        List<Link> linkList = linkService.listLink();
        return Result.ok().put("linkList", linkList);
    }
}
