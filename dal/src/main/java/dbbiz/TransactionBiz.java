package dbbiz;

import data.JpaSpitterRepository;
import entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


public class TransactionBiz {

    @Autowired
    JpaSpitterRepository jpaSpitterRepository;

    @Transactional(rollbackFor = Exception.class)
    public void TransactionAction() throws Exception {
        Spitter spitter = new Spitter();
        spitter.setUsername("zuoll");
        spitter.setEmail("zuoll@yeah.net");
        spitter.setFullName("zuolili");
        spitter.setPassword("zuoll1983");
        spitter.setUpdateByEmail(true);
        Spitter return_spitter1 = jpaSpitterRepository.saveAndFlush(spitter);
        throw new Exception();
    }
}
