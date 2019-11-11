package com.duan.issue.base.dto;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public class PageCondition implements Serializable {

    private static final long serialVersionUID = -8513040746063864619L;
    private Integer currentPage;
    private Integer pageSize;

    public PageCondition() {
    }

    public PageCondition(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
