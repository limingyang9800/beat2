package com.yun.beat.biz.service.impl;

import com.yun.beat.biz.service.DemoService;
import com.yun.beat.dao.entity.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yun.beat.dao.mapper.UserMapper;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDao test(Integer id) {
        UserDao user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void saveUser(UserDao userdao) {
        userMapper.saveUser(userdao);
    }
}
