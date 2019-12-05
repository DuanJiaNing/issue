package com.duan.issue.common.vo;

import java.io.Serializable;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
public class ParliamentaryCountInSessionVO implements Serializable {

    private Long count;

    public ParliamentaryCountInSessionVO() {
    }

    public ParliamentaryCountInSessionVO(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
