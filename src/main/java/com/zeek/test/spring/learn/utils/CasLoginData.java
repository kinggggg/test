package com.zeek.test.spring.learn.utils;

/**
 * @author: weibo_li
 * @since: 2018-02-07 下午4:55
 */
public class CasLoginData {

    private String username;

    private String password;

    private String _eventId;

    private String execution;

    public CasLoginData() {
    }

    public CasLoginData(String username, String password, String _eventId, String execution) {
        this.username = username;
        this.password = password;
        this._eventId = _eventId;
        this.execution = execution;
    }

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

    public String get_eventId() {
        return _eventId;
    }

    public void set_eventId(String _eventId) {
        this._eventId = _eventId;
    }

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }
}
