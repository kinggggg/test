package com.zeek.javatest.gson;

import java.util.Map;


public class RequestInfo {

    private Map<String,Object> mapInfo;

    private String returnResult;

    private String orderNum;

    private String ruleGroupId;

    private String businessManagerId;

    private String businessId;

    private String address;

    private String ruleGroupName;

    private String productModelPackge;

    private String productModelName;

    public Map<String, Object> getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(Map<String, Object> mapInfo) {
        this.mapInfo = mapInfo;
    }

    public String getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(String returnResult) {
        this.returnResult = returnResult;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRuleGroupId() {
        return ruleGroupId;
    }

    public void setRuleGroupId(String ruleGroupId) {
        this.ruleGroupId = ruleGroupId;
    }

    public String getBusinessManagerId() {
        return businessManagerId;
    }

    public void setBusinessManagerId(String businessManagerId) {
        this.businessManagerId = businessManagerId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getRuleGroupName() {
        return ruleGroupName;
    }

    public void setRuleGroupName(String ruleGroupName) {
        this.ruleGroupName = ruleGroupName;
    }

    public String getProductModelPackge() {
        return productModelPackge;
    }

    public void setProductModelPackge(String productModelPackge) {
        this.productModelPackge = productModelPackge;
    }

    public String getProductModelName() {
        return productModelName;
    }

    public void setProductModelName(String productModelName) {
        this.productModelName = productModelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "mapInfo=" + mapInfo +
                ", returnResult='" + returnResult + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", ruleGroupId='" + ruleGroupId + '\'' +
                ", businessManagerId='" + businessManagerId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", address='" + address + '\'' +
                ", ruleGroupName='" + ruleGroupName + '\'' +
                ", productModelPackge='" + productModelPackge + '\'' +
                ", productModelName='" + productModelName + '\'' +
                '}';
    }
}
