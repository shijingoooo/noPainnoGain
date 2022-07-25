package com.shijing.nopainnogain;

import org.casbin.jcasbin.main.Enforcer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CasbinServiceTest extends NopainnogainApplicationTests {

    @Autowired
    private Enforcer enforcer;

    @Test
    public void rbacTest() {
        boolean result = enforcer.enforce("alice", "data1", "write");
        Assert.assertTrue(result);
    }

    @Test
    public void abacTest() {
        Task task01 = new Task(1L, "alice");
        boolean result = enforcer.enforce("alice", task01, "read");
        Assert.assertTrue(result);
    }

    public static class Task {
        private Long id;
        private String owner;

        public Task(Long id, String owner) {
            this.id = id;
            this.owner = owner;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }

}
