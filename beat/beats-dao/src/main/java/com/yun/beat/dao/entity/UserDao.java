package com.yun.beat.dao.entity;


import javax.annotation.Resource;
import java.io.Serializable;

@Resource
public class UserDao implements Serializable {
    private static final long serialVersionUID = 961235512220891746L;

    private Integer id;
    private String name;
    private String information;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", information='" + information + '\'' +
                '}';
    }

    public UserDao(Integer id, String name, String information,String password) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.password = password;
    }

    public UserDao() {
    }
}
