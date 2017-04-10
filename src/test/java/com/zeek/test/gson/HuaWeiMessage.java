package com.zeek.test.gson;

/**
 * Created by weibo_li on 2017/3/30.
 */
public class HuaWeiMessage {

    public HuaWeiMessage() {

    }

    public HuaWeiMessage(String notification_title, String notification_content, int doings, String intent) {
        this.notification_title = notification_title;
        this.notification_content = notification_content;
        this.doings = doings;
        this.intent = intent;
    }

    private String notification_title;

    private String notification_content;

    private int doings;

    private String intent;

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getNotification_content() {
        return notification_content;
    }

    public void setNotification_content(String notification_content) {
        this.notification_content = notification_content;
    }

    public int getDoings() {
        return doings;
    }

    public void setDoings(int doings) {
        this.doings = doings;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }
}
