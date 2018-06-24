package com.jeffrey.templateproject.redisdal.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String sku;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private float price;



}

