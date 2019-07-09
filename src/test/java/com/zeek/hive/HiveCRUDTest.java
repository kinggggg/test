package com.zeek.hive;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName HiveTest
 * @Description 通过JDBC访问hive
 * @Author liweibo
 * @Date 2019/2/27 下午10:12
 * @Version v1.0
 **/
public class HiveCRUDTest {

    Connection conn;

    @Before
    public void initConn() throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        //创建表的时候，需要Linux机器的用户名和密码
        conn = DriverManager.getConnection("jdbc:hive2://s100:10000/hive1", "root", "123456");
    }

    @Test
    public void createTest() throws Exception {

        PreparedStatement ppst = conn.prepareStatement("create table hive1.users(id int, name string, age int)");
        ppst.execute();
        ppst.close();
        conn.close();
    }


}
