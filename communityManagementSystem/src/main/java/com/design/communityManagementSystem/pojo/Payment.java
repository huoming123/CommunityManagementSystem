package com.design.communityManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = 834972112766250433L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 用户id
     */
    private Integer userId;
     /**
     * 创建时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
     /**
     * 年份
     */
    private Integer year;
     /**
     * 月份
     */
    private String month;
     /**
     * 物业费
     */
    private Double fee;
     /**
     * 缴费状态
     */
    private Integer status;
    private String userName;
    private String  address;
    private Boolean disabled;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private Double propertyFee;

    public Double getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Double propertyFee) {
        this.propertyFee = propertyFee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

