package com.duan.issue.common.dto;


import java.io.Serializable;

/**
 * Created on 2019/10/28.
 *
 * @author DuanJiaNing
 */
public class ProposalDTO implements Serializable {

    private static final long serialVersionUID = 5902332795340004546L;
    private String id;
    private String reason;
    private Integer subjectId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
