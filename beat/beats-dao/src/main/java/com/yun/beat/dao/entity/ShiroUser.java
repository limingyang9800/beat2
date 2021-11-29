package com.yun.beat.dao.entity;


import javax.persistence.*;
import java.util.List;

/**
 * @author lmy
 * @date 2021/7/2 16:24
 */
//@Entity
public class ShiroUser {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String username;
    private String password;
    private Integer status;
    private String nickname;
    private String phone;
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "shiroRole")
    private List<ShiroRole> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ShiroRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ShiroRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", roles=" + roles +
                '}';
    }
}
