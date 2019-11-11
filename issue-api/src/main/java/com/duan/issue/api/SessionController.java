package com.duan.issue.api;

import com.duan.issue.common.ResultModel;
import com.duan.issue.manager.SessionGRpcClient;
import com.duan.issue.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/11/09.
 *
 * @author DuanJiaNing
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionGRpcClient sessionGRpcClient;

    @GetMapping("/test")
    public ResultModel<String> test() {
        String join = sessionGRpcClient.join("david");
        return ResultUtils.success(join);
    }


}
