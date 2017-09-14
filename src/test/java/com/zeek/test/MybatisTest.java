package com.zeek.test;

import com.zeek.common.Sex;
import com.zeek.mapper.UserMapper;
import com.zeek.po.User;
import com.zeek.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.UUID;

public class MybatisTest {

    @Test
    public  void test2() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUser("ddde37aa-1bc4-4b41-8a74-734695aeabe3");
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test1() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("zhangsan1");
        user.setSex(Sex.FEMALE);
        userMapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();
    }


}
