package com.zeek.morphia.entity;

/**
 * Created by liyiming on 16/11/1.
 */
public class Payload {

    private MessageInfo messageInfo;

    private SubjectInfo subjectInfo;

    private int subjectAction;

    public MessageInfo getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(MessageInfo messageInfo) {
        this.messageInfo = messageInfo;
    }

    public SubjectInfo getSubjectInfo() {
        return subjectInfo;
    }

    public void setSubjectInfo(SubjectInfo subjectInfo) {
        this.subjectInfo = subjectInfo;
    }

    public int getSubjectAction() {
        return subjectAction;
    }

    public void setSubjectAction(int subjectAction) {
        this.subjectAction = subjectAction;
    }
}
