package com.zeek.domain.constant;

/**
 * Created by liweibo on 17/6/1.
 */
public class MessageSendingQuartz {

    //jobData中存储参数时的key值
    public static final String MESSAGE_SENDER_TYPE = "messageSenderType";

    //jobData中存储参数时的key值
    public static final String MESSAGE_SENDER_BEAN_NAME = "messageSenderBeanName";

    //jobData中存储参数时的key值
    public static final String TASK_ID = "taskId";

    //jobData中存储参数时的key值
    public static final String ORDER_TYPE = "orderType";

    //jobData中存储参数时的key值
    public static final String ORDER_ID = "orderId";

    //jobData中存储参数时的key值
    public static final String CITY_ID = "cityId";

    //jobData中存储参数时的key值
    public static final String EXECUTION_TYPE = "executionType";

    //trigger名称的的前缀
    public static final String TRIGGER_NAME_PREFIX = "messageSenderTrigger";

    //默认triggerGroup名称
    public static final String DEFAULT_TRIGGER_GROUP = "default";

    //默认jobGroup名称
    public static final String DEFAULT_JOB_GROUP = "default";

    public static int current;

    public static int count = 10000;

}
