package com.zeek.domain.quartz;

import org.quartz.SchedulerException;
import org.quartz.spi.InstanceIdGenerator;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by weibo_li on 17/6/1.
 */
public class QuartzInstanceIdGenerator implements InstanceIdGenerator {
    public String generateInstanceId() throws SchedulerException {
        try {
            String id =  InetAddress.getLocalHost().getHostName() + System.currentTimeMillis();
            return id;
        } catch (Exception e) {
            return UUID.randomUUID().toString();
        }
    }
}
