package com.sync.mybatis.model;

import java.util.Date;

public class Points_rule {
    private Integer id;

    private Integer level;

    private Integer consumption;

    private Integer trandNum;

    private Integer condition;

    private Float rate;

    private Date createdAt;

    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    public Integer getTrandNum() {
        return trandNum;
    }

    public void setTrandNum(Integer trandNum) {
        this.trandNum = trandNum;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}