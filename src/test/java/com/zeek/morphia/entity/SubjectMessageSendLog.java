package com.zeek.morphia.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * Created by liyiming on 16/11/10.
 */
@Entity(value = "subjectMessageSendLog", noClassnameStored = true)
public class SubjectMessageSendLog {
    @Id
    private String id;

    private SubjectMessage subjectMessage;

    private Date createDate;

    private int sendType;//1 定时任务 2 接口触发

    private int status; //1发送中 2 成功 3失败

    private String errorMessage;

    private String response;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubjectMessage getSubjectMessage() {
        return subjectMessage;
    }

    public void setSubjectMessage(SubjectMessage subjectMessage) {
        this.subjectMessage = subjectMessage;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
