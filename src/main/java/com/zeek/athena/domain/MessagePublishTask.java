package com.zeek.athena.domain;

import java.util.Date;

public class MessagePublishTask {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.order_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.subject_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String subjectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.order_type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.execution_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Date executionDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.city_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.execution_type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer executionType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.opportunity_subject_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer opportunitySubjectExecutionStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.mobile_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer mobileNotificationExecutionStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.message_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer messageNotificationExecutionStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.we_chat_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer weChatNotificationExecutionStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.create_user_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.trigger_name
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String triggerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.trigger_group
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String triggerGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_publish_task.create_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Date createDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.id
     *
     * @return the value of message_publish_task.id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.id
     *
     * @param id the value for message_publish_task.id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.order_id
     *
     * @return the value of message_publish_task.order_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.order_id
     *
     * @param orderId the value for message_publish_task.order_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.subject_id
     *
     * @return the value of message_publish_task.subject_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.subject_id
     *
     * @param subjectId the value for message_publish_task.subject_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.order_type
     *
     * @return the value of message_publish_task.order_type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.order_type
     *
     * @param orderType the value for message_publish_task.order_type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.execution_date
     *
     * @return the value of message_publish_task.execution_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.execution_date
     *
     * @param executionDate the value for message_publish_task.execution_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.city_id
     *
     * @return the value of message_publish_task.city_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.city_id
     *
     * @param cityId the value for message_publish_task.city_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.execution_type
     *
     * @return the value of message_publish_task.execution_type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getExecutionType() {
        return executionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.execution_type
     *
     * @param executionType the value for message_publish_task.execution_type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setExecutionType(Integer executionType) {
        this.executionType = executionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.opportunity_subject_execution_status
     *
     * @return the value of message_publish_task.opportunity_subject_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getOpportunitySubjectExecutionStatus() {
        return opportunitySubjectExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.opportunity_subject_execution_status
     *
     * @param opportunitySubjectExecutionStatus the value for message_publish_task.opportunity_subject_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setOpportunitySubjectExecutionStatus(Integer opportunitySubjectExecutionStatus) {
        this.opportunitySubjectExecutionStatus = opportunitySubjectExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.mobile_notification_execution_status
     *
     * @return the value of message_publish_task.mobile_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getMobileNotificationExecutionStatus() {
        return mobileNotificationExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.mobile_notification_execution_status
     *
     * @param mobileNotificationExecutionStatus the value for message_publish_task.mobile_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setMobileNotificationExecutionStatus(Integer mobileNotificationExecutionStatus) {
        this.mobileNotificationExecutionStatus = mobileNotificationExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.message_notification_execution_status
     *
     * @return the value of message_publish_task.message_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getMessageNotificationExecutionStatus() {
        return messageNotificationExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.message_notification_execution_status
     *
     * @param messageNotificationExecutionStatus the value for message_publish_task.message_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setMessageNotificationExecutionStatus(Integer messageNotificationExecutionStatus) {
        this.messageNotificationExecutionStatus = messageNotificationExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.we_chat_notification_execution_status
     *
     * @return the value of message_publish_task.we_chat_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getWeChatNotificationExecutionStatus() {
        return weChatNotificationExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.we_chat_notification_execution_status
     *
     * @param weChatNotificationExecutionStatus the value for message_publish_task.we_chat_notification_execution_status
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setWeChatNotificationExecutionStatus(Integer weChatNotificationExecutionStatus) {
        this.weChatNotificationExecutionStatus = weChatNotificationExecutionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.create_user_id
     *
     * @return the value of message_publish_task.create_user_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.create_user_id
     *
     * @param createUserId the value for message_publish_task.create_user_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.trigger_name
     *
     * @return the value of message_publish_task.trigger_name
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.trigger_name
     *
     * @param triggerName the value for message_publish_task.trigger_name
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.trigger_group
     *
     * @return the value of message_publish_task.trigger_group
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getTriggerGroup() {
        return triggerGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.trigger_group
     *
     * @param triggerGroup the value for message_publish_task.trigger_group
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup == null ? null : triggerGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_publish_task.create_date
     *
     * @return the value of message_publish_task.create_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_publish_task.create_date
     *
     * @param createDate the value for message_publish_task.create_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}