package com.zeek.javatest;

/**
 * @author: weibo_li
 * @since: 2018-06-04 下午2:29
 */
public class Outer {

    public static void main(String[] args) {



    }

    public void outerMethod1 () {

        //禁止static修饰
        /*static class publicStaticInner {
            public static int staticVar = 0;

            public int noneStaticVar = 0;

        }*/
    }

    public void outerMethod2 () {

        //只允许默认访问权限
        class publicStaticInner {
            public int staticVar = 0;

            public int noneStaticVar = 0;

        }
    }

    public static class publicStaticInner {
        public static int staticVar = 0;

        public int noneStaticVar = 0;

    }

    protected static class protectedStaticInner {
        public static int staticVar = 0;

        public int noneStaticVar = 0;

    }

    static class defaultStaticInner {
        public static int staticVar = 0;

        public int noneStaticVar = 0;

    }

    private static class privateStaticInner {
        public static int staticVar = 0;

        public int noneStaticVar = 0;

    }

}
