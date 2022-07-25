package com.shijing.nopainnogain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NopainnogainApplicationTests {

    @Configuration
    @Import({DataSourceTestConfig.class})
    public static class TestConfiguration {

    }

    @Test
    public void contextLoads() {
    }

}
