package com.duan.talk.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Data
public class ResultModel<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -2615507408225254664L;
    public static final int SUCCESS = 200;
    public static final int FAIL = 500;

    private String msg;
    private Integer code;
    private T data;

}
