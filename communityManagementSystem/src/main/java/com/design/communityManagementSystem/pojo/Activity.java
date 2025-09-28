package com.design.communityManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Activity)实体类
 *
 * @author makejava
 * @since
 */
public class Activity implements Serializable {
    private static final long serialVersionUID = 379854100324440247L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 活动主题
     */
    private String title;
     /**
     * 录入时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
     /**
     * 开始日期
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
     /**
     * 结束日期
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
     /**
     * 是否显示 1为显示 0 为关闭
     */
    private Integer showIn;
     /**
     * 是否结束 0 为结束 1 为未结束
     */
    private Integer finshed;
     /**
     * 封面照片
     */
    private String images;
     /**
     * 内容描述
     */
    private String contents;
     /**
     * 活动视频
     */
    private String videos;
     /**
     * 人数
     */
    private Integer num;
     /**
     * 地点
     */
    private String address;

    private Integer signedNum;
    private String videosUrl;
    private String imagesUrl;

    public String getVideosUrl() {
        return videosUrl;
    }

    public void setVideosUrl(String videosUrl) {
        this.videosUrl = videosUrl;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Integer getSignedNum() {
        return signedNum;
    }

    public void setSignedNum(Integer signedNum) {
        this.signedNum = signedNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getShowIn() {
        return showIn;
    }

    public void setShowIn(Integer showIn) {
        this.showIn = showIn;
    }

    public Integer getFinshed() {
        return finshed;
    }

    public void setFinshed(Integer finshed) {
        this.finshed = finshed;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

