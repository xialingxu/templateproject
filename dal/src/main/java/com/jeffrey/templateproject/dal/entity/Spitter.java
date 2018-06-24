package com.jeffrey.templateproject.dal.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spitter {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @Column(name="username")
    private String username;

    @Getter
    @Setter
    @Column(name="password")
    private String password;

    @Getter
    @Setter
    @Column(name="fullname")
    private String fullName;

    @Getter
    @Setter
    @Column(name="email")
    private String email;

    @Getter
    @Setter
    @Column(name="updateByEmail")
    private boolean updateByEmail;


    public Spitter(Integer id, String username, String password, String fullName, String email, boolean updateByEmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.updateByEmail = updateByEmail;
    }

    public Spitter(){}

}
