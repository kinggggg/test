package com.zeek.javatest.serializable;

import com.zeek.javatest.collection.arraylist.Person;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author: weibo_li
 * @since: 2018-06-02 下午4:15
 */
public class SerializableTest implements Serializable {

    public static void main(String[] args) throws IOException {
        DataInputStream in =
                new DataInputStream( new BufferedInputStream(System.in));
//        int s = in.read();//这样得到是在控制台输入的数字Ascii码
        String s = in.readLine();
        int i = Integer.valueOf(s);
        float sum = result(i);
        System.out.println(sum);

        new Person();


    }
    private static float result(int i) {
        if(i == 1){
            return 1;
        }else{
            return i*result(i-1);
        }
    }

}
