package com.duan.issue.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Data
public class PageInfo implements Serializable {

    private static final long serialVersionUID = -8513040746063864619L;
    private Integer currentPage;
    private Integer pageSize;
}
