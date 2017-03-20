package com.zeek.morphia.entity.test.String;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

/**
 * Created by weibo_li on 2017/3/20.
 */
public class StringTest {


    @Test
    public void indexOfTest() {
        String str = "abcdefgh" ;

        System.out.println(str.indexOf("h"));

        System.out.println(str.indexOf("h") + 1);
        System.out.println(str.substring(str.indexOf("h") + 1, str.length()).length());


    }

    @Test
    public void indexOfTest2() {
        String str = "acde" ;
        String keyword = "c" ;
        computingHitResult(str, keyword);
    }

    public String computingHitResult(String str, String keyword) {

        if(str != null && !"".equals(str) && keyword != null && !"".equals(keyword)) {
            int keywordLength = keyword.length();//关键字长度
            StringBuffer result = new StringBuffer();//结果字符串
            StringBuffer leftStr = new StringBuffer();//左侧字符串
            StringBuffer rightStr = new StringBuffer();//右侧字符串
            int leftLength = 0;//左侧长度
            int rightLength = 0;//右侧长度
            int startIndex = str.indexOf(keyword); System.out.println("startIndex:" + startIndex); //关键字开始位置
            int endIndex = startIndex + keywordLength; System.out.println("endIndex:" + endIndex);//关键字结束位置

            leftLength = endIndex; System.out.println("leftLength:" + leftLength);
            rightLength = str.substring(endIndex, str.length()).length(); System.out.println("rightLength:" + rightLength);

            //左侧，右侧均大于25
            if(leftLength > WordCount.AVERAGECOUNT && rightLength > WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(endIndex - WordCount.AVERAGECOUNT, endIndex));
                rightStr.append(str.substring(endIndex, endIndex + WordCount.AVERAGECOUNT));
            }

            //左侧小于25，右侧大于25
            if(leftLength < WordCount.AVERAGECOUNT && rightLength > WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                int lack = WordCount.AVERAGECOUNT - leftStr.length();
                rightStr.append(str.substring(endIndex, Math.min(endIndex + WordCount.AVERAGECOUNT + lack, str.length())));//从右侧补齐字数
            }

            //左侧大于25，右侧小于25
            if(leftLength > WordCount.AVERAGECOUNT && rightLength < WordCount.AVERAGECOUNT) {
                rightStr.append(str.substring(endIndex, str.length()));
                int lack = WordCount.AVERAGECOUNT - rightStr.length();
                leftStr.append(str.substring(Math.max(0, endIndex - WordCount.AVERAGECOUNT - lack), endIndex));//从左侧补齐字数
            }

            //左侧，右侧均小于25
            if(leftLength < WordCount.AVERAGECOUNT && rightLength < WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧等于25，右侧大于25
            if(leftLength == WordCount.AVERAGECOUNT && rightLength > WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, endIndex + WordCount.AVERAGECOUNT));
            }

            //左侧等于25，右侧小于25
            if(leftLength == WordCount.AVERAGECOUNT && rightLength < WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧大于25，右侧等于25
            if(leftLength > WordCount.AVERAGECOUNT && rightLength == WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(endIndex - WordCount.AVERAGECOUNT, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧小于25，右侧等于25
            if(leftLength < WordCount.AVERAGECOUNT && rightLength == WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }

            //左侧，右侧均等于25
            if(leftLength == WordCount.AVERAGECOUNT && rightLength == WordCount.AVERAGECOUNT) {
                leftStr.append(str.substring(0, endIndex));
                rightStr.append(str.substring(endIndex, str.length()));
            }


            result.append(leftStr).append(rightStr);

            System.out.println("leftStr:" + leftStr);
            System.out.println("rightStr:" + rightStr);
            System.out.println("result:" + result);

        }


        return "" ;
    }

}
