package com.jeffrey.templateproject.redisdal.redisbiz;

import com.jeffrey.templateproject.redisdal.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisActions {

    @Autowired
    private RedisTemplate<String, Product> redis;

    public void Exec()
    {
        //插入简单数据
        Product product = new Product();
        product.setSku("9781617291203");
        product.setName("Spring in Action");
        product.setPrice(39.99f);

        redis.opsForValue().set(product.getSku(), product);
        Product found = redis.opsForValue().get(product.getSku());

    }
}
