package com.shijing.nopainnogain.spring.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: shijing
 * @Date: 19/7/4 17:32
 * @Description:
 */
@Service
public class ServiceB {

    @Autowired
    private SystemConfigService configService;
    /**
     * 支持当前事务，如果不存在就新建一个
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        configService.addConfig("ServiceB", "service", "B", "");
        //throw new RuntimeException();
    }

    /**
     * 支持当前事务，如果不存在，就不使用事务
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports() {
        configService.addConfig("ServiceB", "service", "B", "");
        throw new RuntimeException();
    }

    /**
     * 支持当前事务，如果不存在，抛出异常
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory() {
        configService.addConfig("ServiceB", "service", "B", "");
    }


    /**
     * 如果有事务存在，挂起当前事务，创建一个新的事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew() {
        configService.addConfig("ServiceB", "service", "B", "");
        throw new RuntimeException();
    }

    /**
     * 以非事务方式运行，如果有事务存在，挂起当前事务
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported() {
        configService.addConfig("ServiceB", "service", "B", "");
        throw new RuntimeException();
    }

    /**
     * 以非事务方式运行，如果有事务存在，抛出异常
     */
    @Transactional(propagation = Propagation.NEVER)
    public void never() {

    }

    /**
     * 如果当前事务存在，则嵌套事务执行
     */
    @Transactional(propagation = Propagation.NESTED)
    public void nested() {

    }

}
