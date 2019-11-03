package com.duan.issue.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/10/29.
 *
 * @author DuanJiaNing
 */
@Data
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

}
