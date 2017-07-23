package com.baidu.jiangchao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jiangchao08 on 17/4/24.
 */
@RestController
@RequestMapping(value = "/service1")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @LoadBalanced
    private RestTemplate loadBalanced;

    @RequestMapping(value = "/hello")
    public String unit() {

        String response = "hello world hello world hello world hello world hello world hello world hello world ";
        logger.info("response: " + response);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/rest")
    public String doOtherStuff() {
        String results = restTemplate.getForObject("https://www.baidu.com/", String.class);
        System.out.println("===========:" + results);
        return results;
    }

}
