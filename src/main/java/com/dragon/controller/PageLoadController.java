package com.dragon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : 龙万恒
 * @date : 2019-10-19 16:50
 */
@Controller
@RequestMapping("/public")
public class PageLoadController {

    @RequestMapping("/page/{path}")
    public String pageLoad(@PathVariable String path) {
        return path;
    }
}
