package com.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author huangsm
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("test")
    public String test() {
        log.info("测试方法:{}", "test");
        return "test";
    }
}
