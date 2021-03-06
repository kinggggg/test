package com.zeek.javatest.object;

/**
 * @ClassName ObjectTest
 * @Description 默认值测试
 * @Author liweibo
 * @Date 2018/11/1 上午9:46
 * @Version v1.0
 **/
public class ObjectTest {

    // false
    private boolean b;

    // null
    private Boolean bb;

    //  
    private char c;

    //private Char cc;

    // 0
    private byte by;

    // null
    private Byte byy;

    // 0
    private short s;

    // null
    private Short ss;

    // 0
    private int i;

    // null
    private Integer ii;

    // 0
    private long l;

    // null
    private Long ll;

    // 0.0
    private float f;

    // null
    private Float ff;

    // 0.0
    private double d;

    // null
    private Double dd;

    // null
    private String str;

    @Override
    public String toString() {
        return "ObjectTest{" +
                "b=" + b +
                ", bb=" + bb +
                ", c=" + c +
                ", by=" + by +
                ", byy=" + byy +
                ", s=" + s +
                ", ss=" + ss +
                ", i=" + i +
                ", ii=" + ii +
                ", l=" + l +
                ", ll=" + ll +
                ", f=" + f +
                ", ff=" + ff +
                ", d=" + d +
                ", dd=" + dd +
                ", str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ObjectTest objectTest = new ObjectTest();
        System.out.println(objectTest);
    }
}
