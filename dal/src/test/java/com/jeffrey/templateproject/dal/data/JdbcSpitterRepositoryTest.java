package com.jeffrey.templateproject.dal.data;

import com.jeffrey.templateproject.dal.config.DalConfig;
import com.jeffrey.templateproject.dal.data.JdbcSpitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DalConfig.class)
//@ActiveProfiles("defaultDataSource")
//@ActiveProfiles("springMVC")
public class JdbcSpitterRepositoryTest {

    @Autowired
    JdbcSpitterRepository jdbcSpitterRepository;

    @Test
    public void findByid() {
        assertEquals("xialingxu", jdbcSpitterRepository.findByid(1).getFullName());
    }
}