package com.zeek.mapper;

import com.zeek.po.User;


public interface UserMapper {

	User getUser(String id);

	int insertUser(User user);
}
