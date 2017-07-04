package com.sync.mybatis.model;

import java.util.Date;

public class Points_record {
    private Integer id;

    private Integer fansId;

    private String openid;

    private String kdtName;

    private String mobile;

    private Integer amount;

    private Integer total;

    private String description;

    private Date createdTime;

    private String clientHash;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getKdtName() {
        return kdtName;
    }

    public void setKdtName(String kdtName) {
        this.kdtName = kdtName == null ? null : kdtName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getClientHash() {
        return clientHash;
    }

    public void setClientHash(String clientHash) {
        this.clientHash = clientHash == null ? null : clientHash.trim();
    }
}