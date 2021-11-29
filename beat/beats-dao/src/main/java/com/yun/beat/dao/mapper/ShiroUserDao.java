package com.yun.beat.dao.mapper;

import com.yun.beat.dao.entity.ShiroUser;

/**
 * @author lmy
 * @date 2021/7/2 17:23
 */
public interface ShiroUserDao extends BaseDao<ShiroUser, Long>{
    ShiroUser findByName(String name);
}
