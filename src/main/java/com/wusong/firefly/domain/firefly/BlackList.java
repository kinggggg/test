package com.wusong.firefly.domain.firefly;

import java.util.Date;

public class BlackList {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column black_list.id
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column black_list.user_id
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column black_list.black_reason
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    private String blackReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column black_list.operator
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    private String operator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column black_list.create_date
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column black_list.update_date
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column black_list.id
     *
     * @return the value of black_list.id
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column black_list.id
     *
     * @param id the value for black_list.id
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column black_list.user_id
     *
     * @return the value of black_list.user_id
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column black_list.user_id
     *
     * @param userId the value for black_list.user_id
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column black_list.black_reason
     *
     * @return the value of black_list.black_reason
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public String getBlackReason() {
        return blackReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column black_list.black_reason
     *
     * @param blackReason the value for black_list.black_reason
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason == null ? null : blackReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column black_list.operator
     *
     * @return the value of black_list.operator
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column black_list.operator
     *
     * @param operator the value for black_list.operator
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column black_list.create_date
     *
     * @return the value of black_list.create_date
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column black_list.create_date
     *
     * @param createDate the value for black_list.create_date
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column black_list.update_date
     *
     * @return the value of black_list.update_date
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column black_list.update_date
     *
     * @param updateDate the value for black_list.update_date
     *
     * @mbggenerated Mon Jun 12 17:13:23 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}