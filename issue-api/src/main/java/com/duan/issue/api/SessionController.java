package com.duan.issue.api;

import com.duan.issue.common.ResultModel;
import com.duan.issue.common.vo.ParliamentaryCountInSessionVO;
import com.duan.issue.service.grpc.interfaces.SessionService;
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
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/{sessionId}/parliamentaryCount")
    public ResultModel<ParliamentaryCountInSessionVO> parliamentaryCount(@PathVariable String sessionId) {
        Long sid = Long.valueOf(sessionId);
        long count = sessionService.parliamentaryCountInSession(sid);
        return ResultUtils.success(new ParliamentaryCountInSessionVO(count));
    }

}
