package com.jeffrey.templateproject.redisdal.redisbiz;

import com.jeffrey.templateproject.redisdal.config.redisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =redisConfig.class)
public class redisActionsTest {

    @Autowired
    RedisActions redisActions;

    @Test
    public void exec() {
        redisActions.Exec();
    }
}