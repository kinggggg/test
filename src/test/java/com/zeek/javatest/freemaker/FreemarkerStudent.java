package com.zeek.javatest.freemaker;

import java.util.Date;

/**
 * @author: weibo_li
 * @since: 2018-08-01 下午2:24
 */
public class FreemarkerStudent {

    public FreemarkerStudent() {

    }

    public FreemarkerStudent(String address, Date birthday) {
        this.address = address;
        this.birthday = birthday;
    }

    private String address;

    private Date birthday;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
