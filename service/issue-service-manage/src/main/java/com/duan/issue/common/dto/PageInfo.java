package com.duan.issue.common.dto;

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
public class PageInfo implements Serializable {

    private static final long serialVersionUID = -3301919414063233247L;
    private Integer currentPage;
    private Integer pageSize;
}
