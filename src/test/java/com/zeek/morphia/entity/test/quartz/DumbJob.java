package com.zeek.morphia.entity.test.quartz;

import org.quartz.*;

/**
 * Created by weibo_li on 2017/3/8.
 */
public class DumbJob implements Job {

    public DumbJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }
}
