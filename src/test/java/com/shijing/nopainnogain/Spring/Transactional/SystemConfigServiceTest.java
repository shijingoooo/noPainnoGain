package com.shijing.nopainnogain.Spring.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: shijing
 * @Date: 19/11/21 16:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemConfigServiceTest {

    @Autowired
    SystemConfigService configService;

    @Test
    public void addConfig() {
        configService.addConfig("master", "master", "1", "1");
    }

    @Test
    public void getConfig() {
        System.out.println(configService.getConfig("master"));
    }
}