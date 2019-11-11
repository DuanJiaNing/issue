package com.duan.issue.common.entity;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public class Manage implements Serializable {

    // TODO seriaID
    private Integer id;
    private Timestamp insertTime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
