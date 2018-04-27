package com.zeek.test.spring.learn.common;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by weibo_li on 16/10/26.
 */
public class FailureResponse {
    private Result result ;

    public FailureResponse(){
        result = new Result();
        result.setCode(1);
        result.setMessage("失败");
        List<String> errorMessages = new ArrayList();
        result.setErrorMessages(errorMessages);
    }

    public FailureResponse(String errorMessage){
        result = new Result();
        result.setCode(1);
        result.setMessage("失败");
        List<String> errorMessages = new ArrayList();
        result.setErrorMessages(errorMessages);
        this.addErrorMessage(errorMessage);
    }

    public FailureResponse(List<String> errorMessages){
        result = new Result();
        result.setCode(1);
        result.setMessage("失败");
        result.setErrorMessages(errorMessages);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void addErrorMessage(String errorMessage){
        this.result.getErrorMessages().add(errorMessage);
    }
}
