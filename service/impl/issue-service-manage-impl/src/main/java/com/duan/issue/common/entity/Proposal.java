package com.duan.issue.common.entity;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/10/29.
 *
 * @author DuanJiaNing
 */
public class Proposal implements Serializable {

    private static final long serialVersionUID = -3874340109656211334L;
    private Integer id;
    private Timestamp insertTime;
    private Timestamp closeTime;

    private Integer status;
    private String reason;
    private Integer proposalType;
    private Integer subjectType;
    private Integer subjectId;
    private Integer agree;
    private Integer disagree;

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

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getProposalType() {
        return proposalType;
    }

    public void setProposalType(Integer proposalType) {
        this.proposalType = proposalType;
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    public Integer getDisagree() {
        return disagree;
    }

    public void setDisagree(Integer disagree) {
        this.disagree = disagree;
    }
}
