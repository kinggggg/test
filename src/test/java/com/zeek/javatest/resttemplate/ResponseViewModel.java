package com.zeek.javatest.resttemplate;

/**
 * Created by liweibo on 17/5/23.
 */
public class ResponseViewModel<T> {

    private Result result ;

    private T data;

    public ResponseViewModel(){
        result = new Result();
        result.setCode(0);
        result.setMessage("服务器错误");
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
