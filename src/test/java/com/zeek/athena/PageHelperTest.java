package com.zeek.athena;

import com.github.pagehelper.PageHelper;
import com.zeek.athena.dao.UserMapper;
import com.zeek.athena.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by weibo_li on 2016/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PageHelperTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    UserMapper userMapper;

    @Test
    public void pageHelperTest2() {

        /**
         * 1.在查询的时候，指定pageNum和pageSize即可
         * 2.也可以在service层中进行设置。即，在service1调用server2的m1方法之前进行设置，然后而在service2中的m1调用了mapper的一个select查询
         */
        PageHelper.startPage(1, 10);

        List<User> userList = userMapper.selectTest();
        System.out.println(userList.size());

    }


}
