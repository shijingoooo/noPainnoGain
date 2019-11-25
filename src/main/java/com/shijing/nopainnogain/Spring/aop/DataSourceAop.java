package com.shijing.nopainnogain.Spring.aop;

import com.shijing.nopainnogain.config.dataSource.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.shijing.nopainnogain.Spring.annotation.Master) " +
            "&& (execution(* com.shijing.nopainnogain.Spring.Transactional..*.select*(..)) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.shijing.nopainnogain.Spring.annotation.Master) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.insert*(..)) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.add*(..)) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.update*(..)) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.edit*(..)) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.delete*(..)) " +
            "|| execution(* com.shijing.nopainnogain.Spring.Transactional..*.remove*(..))")
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
