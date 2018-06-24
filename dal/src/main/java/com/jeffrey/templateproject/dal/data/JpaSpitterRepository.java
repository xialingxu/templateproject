package com.jeffrey.templateproject.dal.data;

import com.jeffrey.templateproject.dal.entity.CustomSpitter;
import com.jeffrey.templateproject.dal.entity.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface JpaSpitterRepository extends JpaRepository<Spitter, Long> {

    Spitter findByUsername(String username);

    List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);

    //@Query("select a from spitter a inner join Spittle b on a.id=b.spitter where b.id=:spittleid")
    @Query(value="select * from spitter a inner join Spittle b on a.id=b.spitter where b.id=:spittleid",nativeQuery = true)
    Spitter readSpitterInnerSpittle(@Param("spittleid") int spittleid);

    @Query(value="select a.username from spitter a inner join Spittle b on a.id=b.spitter where b.id=:spittleid",nativeQuery = true)
    String readStringSpitterInnerSpittle(@Param("spittleid") int spittleid);


   /*以下方法由于不是用的原生sql，因此jpa会校验Spitter与Spittle的Entity*/
    @Query("select new com.jeffrey.templateproject.dal.entity.CustomSpitter(a.username,a.password) from Spitter a inner join Spittle b on a.id=b.spitter where b.id=:spittleid")
    CustomSpitter readCustomSpitterInnerSpittle(@Param("spittleid") int spittleid);

    @Query(value="select a.username,a.password from Spitter a inner join Spittle b on a.id=b.spitter where b.id=:spittleid",nativeQuery = true)
    Object readObjectSpitterInnerSpittle(@Param("spittleid") int spittleid);


}
