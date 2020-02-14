package com.demo.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李小宁
 * @since 2020-02-04
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;
    private String name;
    private Integer age;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
        ", uid=" + uid +
        ", name=" + name +
        ", age=" + age +
        "}";
    }
}
