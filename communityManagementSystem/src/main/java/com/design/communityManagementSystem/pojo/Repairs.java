package com.design.communityManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Repairs)实体类
 *
 * @author makejava
 * @since
 */
public class Repairs implements Serializable {
    private static final long serialVersionUID = 226419687313388647L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 居民编号
     */
    private String userNo;
     /**
     * 手机号码11位
     */
    private String telephone;
     /**
     * 姓名
     */
    private String userName;
     /**
     * 地址
     */
    private String address;
     /**
     * 故障照片
     */
    private String faultImages;
     /**
     * 上报日期
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
     /**
     * 问题描述
     */
    private String descbs;
     /**
     * 维修照片
     */
    private String repairsImages;
     /**
     * 维修状态
     */
    private String status;
     /**
     * 用户id
     */
    private Integer userId;
    private Boolean disabled;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaultImages() {
        return faultImages;
    }

    public void setFaultImages(String faultImages) {
        this.faultImages = faultImages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescbs() {
        return descbs;
    }

    public void setDescbs(String descbs) {
        this.descbs = descbs;
    }

    public String getRepairsImages() {
        return repairsImages;
    }

    public void setRepairsImages(String repairsImages) {
        this.repairsImages = repairsImages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

