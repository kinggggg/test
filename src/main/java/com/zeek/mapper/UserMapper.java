package com.zeek.mapper;

import com.zeek.po.User;

import java.util.List;


public interface UserMapper {

	List<User> bindTest(User user);

	User getUser(String id);

	int insertUser(User user);

	List<User> listUser(User user);

	/**
	 * where会吧if中第一个条件成立的and自动去掉
	 * @param user
	 * @return
	 */
	List<User> practiceWhere(User user);

	List<User> practiceTrim(User user);

	List<User> listAll();
}
