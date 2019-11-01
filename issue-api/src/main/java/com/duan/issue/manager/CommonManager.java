package com.duan.issue.manager;

import com.duan.issue.common.TopicStatus;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/11/1.
 *
 * @author DuanJiaNing
 */
@Slf4j
@Service
public class CommonManager {

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
