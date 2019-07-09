package com.zeek.javatest.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weibo_li on 2017/4/10.
 */
public class MapTest {

    @Test
    public void test() {
        Map<String, Map<String, String>> certificationOrganizationCodeMap = new HashMap<>();

        Map<String, String> qiyeJobCodeMap = new HashMap<>();
        qiyeJobCodeMap.put("0101", "法务");
        qiyeJobCodeMap.put("0102", "公司律师");
        qiyeJobCodeMap.put("0103", "高管");
        qiyeJobCodeMap.put("0104", "工作人员");
        certificationOrganizationCodeMap.put("01", qiyeJobCodeMap);

        //法院
        qiyeJobCodeMap = new HashMap<>();
        qiyeJobCodeMap.put("0201", "法官");
        qiyeJobCodeMap.put("0202", "书记员");
        qiyeJobCodeMap.put("0203", "工作人员");
        certificationOrganizationCodeMap.put("02", qiyeJobCodeMap);


    }
}
