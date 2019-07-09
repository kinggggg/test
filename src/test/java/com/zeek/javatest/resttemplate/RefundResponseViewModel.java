package com.zeek.javatest.resttemplate;


/**
 * Created by liweibo on 17/5/23.
 */
public class RefundResponseViewModel<T> {

    private RefundResult result ;

    private RefundResponse data;

    public RefundResponseViewModel(){
        result = new RefundResult();
        result.setCode(0);
        result.getErrorMessage().add("失败");
    }

    public RefundResult getResult() {
        return result;
    }

    public void setResult(RefundResult result) {
        this.result = result;
    }

    public RefundResponse getData() {
        return data;
    }

    public void setData(RefundResponse data) {
        this.data = data;
    }

}
