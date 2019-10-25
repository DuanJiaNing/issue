package com.duan.talk.utils;

import com.duan.talk.common.ResultModel;
import com.github.pagehelper.Page;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public class ResultUtils {

    public static ResultModel fail(String msg) {
        ResultModel rm = new ResultModel();
        rm.setMsg(msg);
        rm.setCode(ResultModel.FAIL);
        return rm;
    }

    public static ResultModel fail(Throwable e) {
        e.printStackTrace();
        ResultModel rm = new ResultModel();
        rm.setMsg("fail");
        rm.setCode(ResultModel.FAIL);
        return rm;
    }

    public static <T extends Serializable> ResultModel<T> success(T data) {
        ResultModel<T> rm = new ResultModel<T>();
        rm.setMsg("success");
        rm.setData(data);
        rm.setCode(ResultModel.SUCCESS);
        return rm;
    }

    public static boolean emptyPage(Page page) {
        return page == null || page.getTotal() == 0 || page.size() == 0;
    }
}
