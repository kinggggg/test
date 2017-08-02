package com.zeek.test.resttemplate;

import com.wusong.firefly.util.ResourceReader;

/**
 * Created by liweibo on 17/5/23.
 */
public class RefundResponseViewModel<T> {

    private RefundResult result ;

    private RefundResponse data;

    public RefundResponseViewModel(){
        result = new RefundResult();
        result.setCode(0);
        result.getErrorMessage().add(ResourceReader.getCommonsValidationMessage("unified.response.success"));
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
