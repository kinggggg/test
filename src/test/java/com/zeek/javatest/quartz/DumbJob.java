package com.zeek.javatest.quartz;

import org.quartz.*;

import java.util.ArrayList;

/**
 * Created by weibo_li on 2017/3/8.
 */
@DisallowConcurrentExecution
public class DumbJob implements Job {

    String jobSays;
    float myFloatValue;
    ArrayList state;

    public DumbJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        System.out.println("每次执行Job时，都是不同的实例对象" + this);

//        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);

        try {
            Thread.sleep(1000);
        }catch (Exception e) {

        }
    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    public void setState(ArrayList state) {
        this.state = state;
    }
}
