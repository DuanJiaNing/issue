package com.duan.issue.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCondition implements Serializable {

    private static final long serialVersionUID = -8513040746063864619L;
    private Integer currentPage;
    private Integer pageSize;
}
