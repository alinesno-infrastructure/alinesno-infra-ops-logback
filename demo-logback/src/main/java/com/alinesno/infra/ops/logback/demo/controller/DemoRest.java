package com.alinesno.infra.ops.logback.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * demo controller
 */
@RestController
public class DemoRest {

    private static final Logger log = LoggerFactory.getLogger(DemoRest.class) ;

    @Autowired
    HttpServletRequest request ;

    @GetMapping("/thread")
    public String thread(){
        String size = request.getParameter("size")  ;

        int sizeInt = 10000 ;
        if(size != null){
            sizeInt = Integer.parseInt(size) ;
        }

        int threadCount = 50;
        int count = 0 ;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < sizeInt; i++) {
            final int index = i;
            executorService.execute(() -> {
                // 设置MDC的值
                MDC.put("requestId", "12345");
                MDC.put("userId", "john_doe");

                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");
                log.debug(index + " ===>>> this is a test of page!!");

                // 清除MDC的值
                MDC.clear();
            });
        }

        executorService.shutdown();
        return "发送的日志消息为:" + count  ;
    }

    @GetMapping("/batch")
    public String batch(){

        String size = request.getParameter("size")  ;

        int sizeInt = 100 ;
        if(size != null){
            sizeInt = Integer.parseInt(size) ;
        }

        int count = 0 ;

        for(int i = 0 ; i < sizeInt ; i++){
            // 设置MDC的值
            MDC.put("requestId", "12345");
            MDC.put("userId", "john_doe");

            count ++ ;

            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");

            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");

            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");


            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");

            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
            log.debug(i + " ===>>> this is a test of page!!");
        }

        return "发送的日志消息为:" + count  ;
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