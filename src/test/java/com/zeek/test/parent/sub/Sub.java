package com.zeek.test.parent.sub;

import com.zeek.test.parent.Parent;

/**
 * Created by weibo_li on 2017/1/11.
 */
public class Sub extends Parent {

    public void cost() {
        super.cost();
        System.out.println("sub cost");
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.cost();
    }
}
