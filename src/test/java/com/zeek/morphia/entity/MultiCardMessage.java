package com.zeek.morphia.entity;

import java.util.List;

/**
 * Created by liyiming on 16/11/1.
 */
public class MultiCardMessage {

    private String title;

    private List<CardMessage> cards;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CardMessage> getCards() {
        return cards;
    }

    public void setCards(List<CardMessage> cards) {
        this.cards = cards;
    }
}
