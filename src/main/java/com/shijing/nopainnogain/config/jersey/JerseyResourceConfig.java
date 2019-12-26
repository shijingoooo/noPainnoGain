package com.shijing.nopainnogain.config.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

public class JerseyResourceConfig extends ResourceConfig {

    public JerseyResourceConfig() {
        register(RequestContextFilter .class);
        // 加载资源文件,这里直接扫描com.example.demo.controller下的所有api

        packages("com.shijing.nopainnogain.spring.controller");
        //register(HelloController.class);  //@wjw_note: 这种是注册单个的 JAX-RS component!
    }

}
