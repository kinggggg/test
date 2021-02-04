package com.zeek.javatest.genericstest;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2021-02-02
 */
public class Generic {



    public <E> void printMsg( E... args){
        for(E t : args){
            System.out.println(t.getClass());
            System.out.println("泛型测试t is " + t);
        }
    }

    public static void main(String[] args) {
        Generic generic = new Generic();

        generic.printMsg(true, "111",222,"aaaa","2323.4",55.55, new Object());
    }
}
