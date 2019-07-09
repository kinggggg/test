package com.zeek.spring.password;

import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author: weibo_li
 * @since: 2018-02-05 上午10:24
 */
public class CustomPasswordEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence password) {
        try {
            //给数据进行md5加密
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.toString().getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodePassword) {
        // 判断密码是否存在
        if (rawPassword == null) {
            return false;
        }

        //通过md5加密后的密码
        String pass = this.encode(rawPassword.toString());
        //比较密码是否相等的问题
        return pass.equals(encodePassword);
    }

    @Test
    public void test1() {
        System.out.println(new CustomPasswordEncoder().encode("111111"));
    }
}
