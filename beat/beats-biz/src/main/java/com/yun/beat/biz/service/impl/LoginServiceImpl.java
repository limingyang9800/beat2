package com.yun.beat.biz.service.impl;

import com.yun.beat.biz.service.LoginService;
import com.yun.beat.dao.entity.ShiroPermission;
import com.yun.beat.dao.entity.ShiroRole;
import com.yun.beat.dao.entity.ShiroUser;
import com.yun.beat.dao.mapper.ShiroRoleDao;
import com.yun.beat.dao.mapper.ShiroUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lmy
 * @date 2021/7/2 17:29
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private ShiroUserDao shiroUserDao;

    @Autowired
    private ShiroRoleDao shiroRoleDao;

    //添加用户
    @Override
    public ShiroUser addUser(ShiroUser user) {
        shiroUserDao.save(user);
        return user;
    }

    //添加角色
    @Override
    public ShiroRole addRole(ShiroRole role) {
        ShiroUser user = shiroUserDao.findByName(role.getShiroUser().getUsername());
        role.setShiroUser(user);
        ShiroPermission permission1 = new ShiroPermission();
        permission1.setName("create");
        permission1.setShiroRole(role);

        ShiroPermission permission2 = new ShiroPermission();
        permission1.setName("update");
        permission1.setShiroRole(role);

        List<ShiroPermission> permissions = new ArrayList<ShiroPermission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setShiroPermission(permissions);
        shiroRoleDao.save(role);
        return role;

    }

    @Override
    public ShiroUser findByName(String name) {
        return shiroUserDao.findByName(name);
    }
}
