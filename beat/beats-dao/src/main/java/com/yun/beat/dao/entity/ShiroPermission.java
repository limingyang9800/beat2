package com.yun.beat.dao.entity;

import javax.persistence.*;

/**
 * @author lmy
 * @date 2021/7/2 16:52
 */
//@Entity
public class ShiroPermission {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    private Integer type;
    private Integer sort;
    //@ManyToOne(fetch = FetchType.EAGER)
    private ShiroRole shiroRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public ShiroRole getShiroRole() {
        return shiroRole;
    }

    public void setShiroRole(ShiroRole shiroRole) {
        this.shiroRole = shiroRole;
    }

    @Override
    public String toString() {
        return "ShiroPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", sort=" + sort +
                ", shiroRole=" + shiroRole +
                '}';
    }
}
