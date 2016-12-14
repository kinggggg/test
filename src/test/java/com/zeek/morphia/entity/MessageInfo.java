package com.zeek.morphia.entity;

/**
 * Created by liyiming on 16/11/1.
 */
public class MessageInfo {

    private String id;

    private String subjectId;

    private int type;//消息类型：1、单卡，2、多卡，3、信息

    private SimpleMessage simpleMessage;

    private CardMessage singleCard;

    private MultiCardMessage multiCard;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public SimpleMessage getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(SimpleMessage simpleMessage) {
        this.simpleMessage = simpleMessage;
    }

    public CardMessage getSingleCard() {
        return singleCard;
    }

    public void setSingleCard(CardMessage singleCard) {
        this.singleCard = singleCard;
    }

    public MultiCardMessage getMultiCard() {
        return multiCard;
    }

    public void setMultiCard(MultiCardMessage multiCard) {
        this.multiCard = multiCard;
    }
}
