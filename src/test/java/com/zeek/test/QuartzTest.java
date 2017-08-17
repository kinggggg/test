package com.zeek.test;

import com.zeek.domain.constant.MessageSendingQuartz;
import com.zeek.domain.job.HelloJob;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by weibo_li on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class QuartzTest {

    final Logger logger  =  LoggerFactory.getLogger(QuartzTest.class );

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Scheduler scheduler;

    private List exceptins = new ArrayList<>();

    @BeforeClass
    public static void beforeTest() throws Exception {

    }

    @Test
    public void test1() throws Exception {
        String jobName = "helloJob";
        String jobGroup = MessageSendingQuartz.DEFAULT_JOB_GROUP;
        String triggerName ;
        String triggerGroup = MessageSendingQuartz.DEFAULT_TRIGGER_GROUP;
        Date startTime = new Date();

        int count = MessageSendingQuartz.count;
        for(int i = 0; i < count; i++) {
//            jobName = "jobName" + UUID.randomUUID().toString();
//            jobGroup = "jobGroup" + UUID.randomUUID().toString();
            triggerName = "triggerName" + MessageSendingQuartz.TRIGGER_NAME_PREFIX + UUID.randomUUID().toString();
//            triggerGroup = "triggerGroup" + UUID.randomUUID().toString();

            logger.info( i + "/" + count + "|" +"添加任务： jobName = " + jobName + "; jobGroup = " + jobGroup + "; triggerName = " + triggerName + "; triggerGroup = " + triggerGroup + "; stratTime = " + startTime);
            this.schedule(jobName, jobGroup, triggerName, triggerGroup, startTime);
        }

        logger.info("异常的任务列表" + exceptins);

        Thread.sleep(1000 * 600);

    }

    public void schedule(String jobName, String jobGroup, String triggerName, String triggerGroup, Date startTime)
            throws Exception {

        try {
            Class jobClass = applicationContext.getType("helloJob");

            JobDetail job = newJob(jobClass)
                    .withIdentity(jobName, jobGroup)
                    .storeDurably(true)
                    .build();

            this.scheduler.addJob(job, true);

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("triggerName", triggerName);

            SimpleTrigger trigger = newTrigger()
                    .withIdentity(triggerName, triggerGroup)
                    .startAt(startTime)
                    .withSchedule(simpleSchedule().withIntervalInMilliseconds(0)
                            .withRepeatCount(0))
                    .forJob(jobName, jobGroup) // identify job with name, group strings
                    .build();

            scheduler.scheduleJob(trigger);

        } catch (SchedulerException e) {
            exceptins.add(triggerName);
            logger.error("创建Quartz定时任务出现问题: ", e);
        }
    }
}
