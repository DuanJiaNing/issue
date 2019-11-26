package com.duan.issue.common.vo;

import java.io.Serializable;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
public class UserCountInSessionVO implements Serializable {

    private Integer count;

    public UserCountInSessionVO() {
    }

    public UserCountInSessionVO(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
