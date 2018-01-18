package com.example.myyuekaodemo;

import java.util.List;

/**
 * Created by 执笔画商
 * on 2018/1/16.
 * at 北京
 */

public class MyBean {

    /**
     * images : ["https://img14.360buyimg.com/n5/jfs/t11338/95/1722287059/812729/46359f11/5a0723f8N0f5dfb32.jpg"]
     * id : 1
     * name : 俞兆林保暖内衣加绒加厚男女情侣款套装咖啡绒双层防寒打底秋衣秋裤 男款 深灰XL
     * price : 115
     * type : 0
     */

    private String id;
    private String name;
    private String price;
    private int type;
    private List<String> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
