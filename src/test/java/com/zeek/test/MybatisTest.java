package com.zeek.test;

import com.zeek.common.Sex;
import com.zeek.mapper.UserMapper;
import com.zeek.po.User;
import com.zeek.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class MybatisTest {

    @Test
    public  void test7() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("张三");
        List<User> users = userMapper.bindTest(user);
        System.out.println(users);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test6() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.listAll();
        System.out.println(users);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test5() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京市");

        List<User> users = userMapper.practiceTrim(user);
        System.out.println(users);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test4() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京市");

        List<User> users = userMapper.practiceWhere(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test3() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京市");

        List<User> users = userMapper.listUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test2() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUser("1");
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void test1() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("aaaa");
        user.setSex(Sex.MALE);
        userMapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();
    }


}
