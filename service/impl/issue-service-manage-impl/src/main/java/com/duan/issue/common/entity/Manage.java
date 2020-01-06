package com.duan.issue.common.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Data
public class Manage implements Serializable {

    private static final long serialVersionUID = -2432682745862505668L;
    private Integer id;
    private Timestamp insertTime;

    private Integer status;
}
