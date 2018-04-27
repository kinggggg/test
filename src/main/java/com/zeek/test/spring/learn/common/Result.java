package com.zeek.test.spring.learn.common;


import java.util.List;

public class Result {

    // 0 -> success
    // 1 -> failure
    private int code;

    // if code is 0, the message will always be '成功',
    // otherwise the message will be error content
    private String message;

    private List<String> errorMessages ;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
