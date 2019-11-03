package com.duan.issue.common;

import com.duan.issue.base.service.Service;
import com.duan.issue.common.enums.ProposalSubjectType;
import com.duan.issue.service.CommentService;
import com.duan.issue.service.TopicService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/11/03.
 *
 * @author DuanJiaNing
 */
@Component
public class ProposalSubjectFactory {

    @Reference
    private CommentService commentService;

    @Reference
    private TopicService topicService;

    public Service getSubjectService(ProposalSubjectType type) {
        switch (type) {
            case TOPIC:
                return topicService;
            case COMMENT:
                return commentService;
            default:
                return null;
        }
    }

}
