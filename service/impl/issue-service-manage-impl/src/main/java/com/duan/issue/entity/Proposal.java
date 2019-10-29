package com.duan.issue.entity;

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
    private String id;
    private Timestamp insertTime;

    private Integer proposalType;
    private Integer subjectType;
    private String subjectId;
    private Integer agree;
    private Integer disagree;

}
