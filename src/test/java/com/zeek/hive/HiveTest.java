package com.zeek.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName HiveTest
 * @Description 通过JDBC访问hive
 * @Author liweibo
 * @Date 2019/2/27 下午10:12
 * @Version v1.0
 **/
public class HiveTest {

    public static void main(String[] args) throws Exception {

        Class.forName("org.apache.hive.jdbc.HiveDriver");

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://s100:10000/hive1", "", "");

        // create statement
        PreparedStatement ppst = con.prepareStatement("select * from t");

        ResultSet resultSet = ppst.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(id + ", " + name + ", " + age);
        }

        resultSet.close();
        ppst.close();
        con.close();

    }


}
