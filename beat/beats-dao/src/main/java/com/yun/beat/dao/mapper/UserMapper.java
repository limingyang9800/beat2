package com.yun.beat.dao.mapper;

import com.yun.beat.dao.entity.UserDao;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
  UserDao selectByPrimaryKey(Integer id);
  void saveUser(UserDao userdao);
}
