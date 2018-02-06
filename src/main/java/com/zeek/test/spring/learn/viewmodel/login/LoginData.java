package com.zeek.test.spring.learn.viewmodel.login;

/**
 * @author: weibo_li
 * @since: 2018-02-05 下午4:19
 */
public class LoginData {

    public LoginData() {

    }

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
