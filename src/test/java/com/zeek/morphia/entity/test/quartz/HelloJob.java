package com.zeek.morphia.entity.test.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by weibo_li on 2017/3/8.
 */
public class HelloJob implements Job {

    public HelloJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }

}
