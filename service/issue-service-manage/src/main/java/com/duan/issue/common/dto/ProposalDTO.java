package com.duan.issue.common.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/10/28.
 *
 * @author DuanJiaNing
 */
@Data
public class ProposalDTO implements Serializable {

    private static final long serialVersionUID = 5902332795340004546L;
    private String id;
    private String reason;
    private Integer subjectId;
}
