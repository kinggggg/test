package com.zeek.reactor;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-10-30
 */
public class Player {

    private String name1;

    private String name2;

    public Player() {

    }

    public Player(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
