package com.zeek.mapper;

import com.zeek.po.User;

import java.util.List;


public interface UserMapper {

	User getUser(String id);

	int insertUser(User user);

	List<User> listUser(User user);

	List<User> practiceWhere(User user);
}
