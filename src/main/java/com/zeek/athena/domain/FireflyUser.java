package com.zeek.athena.domain;

import java.util.Date;

public class FireflyUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column firefly_user.user_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column firefly_user.type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column firefly_user.open_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private String openId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column firefly_user.select_city_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Integer selectCityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column firefly_user.create_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column firefly_user.update_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column firefly_user.user_id
     *
     * @return the value of firefly_user.user_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column firefly_user.user_id
     *
     * @param userId the value for firefly_user.user_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column firefly_user.type
     *
     * @return the value of firefly_user.type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column firefly_user.type
     *
     * @param type the value for firefly_user.type
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column firefly_user.open_id
     *
     * @return the value of firefly_user.open_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column firefly_user.open_id
     *
     * @param openId the value for firefly_user.open_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column firefly_user.select_city_id
     *
     * @return the value of firefly_user.select_city_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Integer getSelectCityId() {
        return selectCityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column firefly_user.select_city_id
     *
     * @param selectCityId the value for firefly_user.select_city_id
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setSelectCityId(Integer selectCityId) {
        this.selectCityId = selectCityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column firefly_user.create_date
     *
     * @return the value of firefly_user.create_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column firefly_user.create_date
     *
     * @param createDate the value for firefly_user.create_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column firefly_user.update_date
     *
     * @return the value of firefly_user.update_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column firefly_user.update_date
     *
     * @param updateDate the value for firefly_user.update_date
     *
     * @mbggenerated Fri Jun 02 17:10:40 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}