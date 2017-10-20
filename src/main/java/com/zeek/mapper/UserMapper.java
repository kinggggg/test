package com.zeek.mapper;

import com.zeek.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

	//mybatis bind使用第二种方式：java接口中使用对象参数"
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
