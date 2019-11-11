package com.duan.issue.manager;

import com.duan.issue.common.TopicStatus;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.service.TopicService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/11/1.
 *
 * @author DuanJiaNing
 */
@Service
public class CommonManager {

    private static Logger log = LoggerFactory.getLogger(CommonManager.class);

    @Reference
    private TopicService topicService;

    public boolean topicExist(int topicId) {
        TopicDTO topicDTO = topicService.get(topicId);
        if (topicDTO == null) {
            log.warn("topic is not exist: id=" + topicId);
            return false;
        }

        if (topicDTO.getStatus() == TopicStatus.DELETED.ordinal()) {
            log.warn("topic status error: DELETE, not allow to comment");
            return false;
        }

        return true;
    }

}
