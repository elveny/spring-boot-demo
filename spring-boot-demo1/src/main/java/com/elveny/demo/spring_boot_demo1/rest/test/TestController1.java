package com.elveny.demo.spring_boot_demo1.rest.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elven on 2016/8/16.
 */
@CrossOrigin(origins = {"http://127.0.0.1:8888", "http://localhost:8888"}, maxAge = 3600)
@RestController
@RequestMapping("rest/test1")
public class TestController1 {
    private static final Logger logger = LoggerFactory.getLogger(TestController1.class);

    @RequestMapping("test1")
    @ResponseBody
    String test1() {
        System.out.println("start test1.test1...");
        return "test1.test1";
    }
}
