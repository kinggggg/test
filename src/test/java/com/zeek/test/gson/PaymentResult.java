package com.zeek.test.gson;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by liweibo on 17/5/23.
 */
public class PaymentResult {

    // 0 -> success
    // 1 -> failure
    private int code;

    private List<String> errorMessage = new ArrayList<>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }
}
