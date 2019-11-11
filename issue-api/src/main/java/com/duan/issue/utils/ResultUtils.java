package com.duan.issue.utils;

import com.duan.issue.common.ResultModel;
import com.github.pagehelper.Page;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public class ResultUtils {

    // user understandable
    public static ResultModel error(String msg) {
        ResultModel rm = new ResultModel();
        rm.setMsg(msg);
        rm.setCode(HttpStatus.OK.value());
        return rm;
    }

    // user can not understand, dev can
    public static ResultModel fail(String msg, HttpStatus httpCode) {
        ResultModel rm = new ResultModel();
        rm.setMsg(msg);
        rm.setCode(httpCode.value());
        return rm;
    }

    public static ResultModel fail(Throwable e) {
        e.printStackTrace();
        LoggerFactory.getLogger(ResultUtils.class).error("error when handle request", e);

        ResultModel rm = new ResultModel();
        rm.setMsg(e.getMessage());
        rm.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return rm;
    }

    public static <T extends Serializable> ResultModel<T> success(T data) {
        ResultModel<T> rm = new ResultModel<T>();
        rm.setMsg("success");
        rm.setData(data);
        rm.setCode(HttpStatus.OK.value());
        return rm;
    }

    public static boolean emptyPage(Page page) {
        return page == null || page.getTotal() == 0 || page.size() == 0;
    }
}
