package com.yun.beat.biz.service;

import com.yun.beat.dao.entity.UserDao;

public interface DemoService {
    UserDao test(Integer id);
    void saveUser(UserDao userdao);
}
