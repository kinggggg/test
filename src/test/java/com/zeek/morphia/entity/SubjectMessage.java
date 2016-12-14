package com.zeek.morphia.entity;

import java.util.List;

/**
 * Created by liyiming on 16/11/1.
 */
public class SubjectMessage {

    private int type;

    private int target;

    private Payload payload;

    private String publishDate;

    private List<String> userIds; //1:全部用户;2:登录用户;3:未登录用户;4:victoryUserList;5:hanukkahUserList;6:profileIdList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
