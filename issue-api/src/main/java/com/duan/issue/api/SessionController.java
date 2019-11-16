package com.duan.issue.api;

import com.duan.issue.common.ResultModel;
import com.duan.issue.common.vo.UserCountInSessionVO;
//import com.duan.issue.service.SessionService;
import com.duan.issue.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//
//    @Autowired
//    private SessionService sessionService;
//
//    @GetMapping("/count/{sessionId}")
//    public ResultModel<UserCountInSessionVO> userCountInSession(@PathVariable String sessionId) {
//        int count = sessionService.userCountInSession(sessionId);
//
//        return ResultUtils.success(count);
//    }

}
