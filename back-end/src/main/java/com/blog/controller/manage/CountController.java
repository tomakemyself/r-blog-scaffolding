package com.blog.controller.manage;

import com.blog.common.Result;
import com.blog.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rubin on 2020-02-13.
 */
@RestController
@RequestMapping("/admin/count")
public class CountController {

    @Autowired
    private CountService countService;

    @GetMapping("/getCount")
    public Result getCount() {
        return countService.getCount();
    }

}
