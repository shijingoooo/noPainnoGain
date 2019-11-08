package com.shijing.nopainnogain.Spring.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: shijing
 * @Date: 19/7/5 14:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceATest {

    @Autowired
    ServiceA sa;

    @Test
    public void required() {
        sa.required();
    }

    @Test
    public void supports() {
        sa.supports();
    }

    @Test
    public void mandatory() {
        sa.mandatory();
    }

    @Test
    public void requiresNew() {
        sa.requiresNew();
    }

    @Test
    public void notSupported() {
        sa.notSupported();
    }

    @Test
    public void never() {
    }

    @Test
    public void nested() {
    }
}