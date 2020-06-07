package com.shijing.nopainnogain.spring.aop;

import com.shijing.nopainnogain.config.dataSource.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.shijing.nopainnogain.spring.annotation.Master) " +
            "&& (execution(* com.shijing.nopainnogain.spring.transactional..*.select*(..)) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.shijing.nopainnogain.spring.annotation.Master) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.insert*(..)) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.add*(..)) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.update*(..)) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.edit*(..)) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.delete*(..)) " +
            "|| execution(* com.shijing.nopainnogain.spring.transactional..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
