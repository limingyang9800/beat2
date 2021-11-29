package com.yun.beat.biz.service;

import com.yun.beat.dao.entity.ShiroRole;
import com.yun.beat.dao.entity.ShiroUser;

/**
 * @author lmy
 * @date 2021/7/2 17:28
 */
public interface LoginService {
    ShiroUser addUser(ShiroUser user);

    ShiroRole addRole(ShiroRole role);

    ShiroUser findByName(String name);
}
