package com.elveny.demo.spring_boot_demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by elven on 2016/8/16.
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
//@EnableGlobalMethodSecurity
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        logger.info("::start run application::::::");
        SpringApplication.run(Application.class, args);
        logger.info("::::::application run completely!!!::");
    }
}
