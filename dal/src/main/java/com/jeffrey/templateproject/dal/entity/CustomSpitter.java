package com.jeffrey.templateproject.dal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

public class CustomSpitter {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    public CustomSpitter(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public CustomSpitter(){}
}
