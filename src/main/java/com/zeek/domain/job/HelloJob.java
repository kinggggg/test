package com.zeek.domain.job;

import com.zeek.domain.constant.MessageSendingQuartz;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by weibo_li on 2017/8/9.
 */
public class HelloJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String triggerName = context.getTrigger().getJobDataMap().getString("triggerName");

        MessageSendingQuartz.current = MessageSendingQuartz.current + 1;

        logger.info(MessageSendingQuartz.current + "/" + MessageSendingQuartz.count + " Hello World! " + triggerName + " - " + new Date());

    }

}
