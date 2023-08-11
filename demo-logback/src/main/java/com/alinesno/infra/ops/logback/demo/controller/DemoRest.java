package com.alinesno.infra.ops.logback.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 */
@RestController
public class DemoRest {

    private static final Logger log = LoggerFactory.getLogger(DemoRest.class) ;

    @GetMapping("/index")
    public String index(){
        return "this is a test";
    }

}