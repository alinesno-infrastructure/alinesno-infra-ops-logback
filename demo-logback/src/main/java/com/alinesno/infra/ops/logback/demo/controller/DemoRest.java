package com.alinesno.infra.ops.logback.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 */
@RestController
public class DemoRest {

    private static final Logger log = LoggerFactory.getLogger(DemoRest.class) ;

    @GetMapping("/batch")
    public String batch(){

        for(int i = 0 ; i < 10000 ; i++){
            // 设置MDC的值
            MDC.put("requestId", "12345");
            MDC.put("userId", "john_doe");

            log.debug(i + "this is a test of page!!");
            log.trace(i + "this is a test of page!!");
            log.info(i+ " this is a test of page!!");
            log.error(i + "this is a test of page!!");
        }

        return "this is a test";
    }


    @GetMapping("/index")
    public String index(){

        // 设置MDC的值
        MDC.put("requestId", "12345");
        MDC.put("userId", "john_doe");

        log.debug("this is a test of page!!");
        log.trace("this is a test of page!!");
        log.info("this is a test of page!!");
        log.error("this is a test of page!!");

        return "this is a test";
    }

    @GetMapping("/error")
    public String error(){

        int i = 10/0 ;

        return "this is a test";
    }

}