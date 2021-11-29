package com.yun.beat.dao.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author lmy
 * @date 2021/7/2 16:28
 */

//@Entity
public class ShiroRole {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    //@ManyToOne(fetch = FetchType.EAGER)
    private ShiroUser shiroUser;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<ShiroPermission> shiroPermission;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ShiroUser getShiroUser() {
        return shiroUser;
    }

    public void setShiroUser(ShiroUser shiroUser) {
        this.shiroUser = shiroUser;
    }

    public List<ShiroPermission> getShiroPermission() {
        return shiroPermission;
    }

    public void setShiroPermission(List<ShiroPermission> shiroPermission) {
        this.shiroPermission = shiroPermission;
    }

    @Override
    public String toString() {
        return "ShiroRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shiroUser=" + shiroUser +
                ", shiroPermission=" + shiroPermission +
                '}';
    }
}
