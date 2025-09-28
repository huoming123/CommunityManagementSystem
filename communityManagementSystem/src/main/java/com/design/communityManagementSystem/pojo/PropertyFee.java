package com.design.communityManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (PropertyFee)实体类
 *
 * @author makejava
 * @since
 */
public class PropertyFee implements Serializable {
    private static final long serialVersionUID = 432959876203292715L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 录入时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 年份
     */
    private Integer year;
     /**
     * 收费标准
     */
    private Double fee;
     /**
     * 月份
     */
    private String month;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

}

