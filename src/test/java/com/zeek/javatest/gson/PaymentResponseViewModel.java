package com.zeek.javatest.gson;

/**
 * Created by liweibo on 17/5/23.
 */
public class PaymentResponseViewModel<T> {

    private PaymentResult result ;

    private T data;

    public PaymentResponseViewModel(){
        result = new PaymentResult();
        result.setCode(0);
        result.getErrorMessage().add("错误");
    }

    public PaymentResult getResult() {
        return result;
    }

    public void setResult(PaymentResult result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
