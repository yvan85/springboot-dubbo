package com.zy.springboot.bean;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
