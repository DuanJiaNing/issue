package com.duan.issue.entity;

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

    private String id;
    private Timestamp insertTime;

    private Integer status;

}
