package com.jeffrey.templateproject.dal.data;


import com.jeffrey.templateproject.dal.config.JpaConfig;
import com.jeffrey.templateproject.dal.data.JpaSpitterRepository;
import com.jeffrey.templateproject.dal.entity.CustomSpitter;
import com.jeffrey.templateproject.dal.entity.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class JpaSpitterRepositoryTest {

    @Autowired
    JpaSpitterRepository jpaSpitterRepository;

    /*默认条件查询*/
    @Test
    public void findByUsername() {
        Spitter spitter=jpaSpitterRepository.findByUsername("jeffrey");
        assertEquals("xialingxu",spitter.getFullName());
    }

    @Test
    public void findByUsernameOrFullNameLike() {
    }

    /*自定义sql语句返回Entity*/
    @Test
    public void readSpitterInnerSpittle() {
        Spitter spitter=jpaSpitterRepository.readSpitterInnerSpittle(5);
        assertEquals("xialingxu",spitter.getFullName());
    }

    /*自定义sql语句返回简单类型*/
    @Test
    public void readStringSpitterInnerSpittle() {
        String fullname=jpaSpitterRepository.readStringSpitterInnerSpittle(5);
        assertEquals("xialingxu",fullname);
    }

    /*自定义sql语句返回自定义对象类型，采用Object作为中间对象*/
    @Test
    public void readObjectSpitterInnerSpittle() {
        Object object=jpaSpitterRepository.readObjectSpitterInnerSpittle(5);
        assertEquals("mwalls",((Object[])object)[0]);
    }

    /*自定义sql语句返回自定义对象类型，采用Entity关联方案*/
    @Test
    public void readCustomSpitterInnerSpittle() {
        CustomSpitter customSpitter=jpaSpitterRepository.readCustomSpitterInnerSpittle(5);
        assertEquals("xialing",customSpitter.getUsername());
    }

    /*插入数据*/
    @Test
    public void insertSpitter()
    {
        Spitter spitter=new Spitter();
        spitter.setUsername("zuoll");
        spitter.setEmail("zuoll@yeah.net");
        spitter.setFullName("zuolili");
        spitter.setPassword("zuoll1983");
        spitter.setUpdateByEmail(true);
        Spitter return_spitter=jpaSpitterRepository.saveAndFlush(spitter);

        String str="";
    }


    /*事务处理*/
    @Test
    @Transactional
    public void insertTransaction()
    {
        Spitter spitter=new Spitter();
        spitter.setUsername("zuoll");
        spitter.setEmail("zuoll@yeah.net");
        spitter.setFullName("zuolili");
        spitter.setPassword("zuoll1983");
        spitter.setUpdateByEmail(true);
        Spitter return_spitter=jpaSpitterRepository.saveAndFlush(spitter);
        //throw new Exception("sysconfig error");
    }
}