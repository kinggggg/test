package com.zeek.springdataentity;

import org.springframework.data.annotation.Id;

/**
 * Created by weibo_li on 16/5/17.
 */
public class Address {

    @Id
    private String id;

    private String name;

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

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
