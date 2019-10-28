package com.duan.issue.impl;

import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.exceptions.TopicException;
import com.duan.issue.dao.TopicDao;
import com.duan.issue.service.TopicService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public TopicDTO get(int id) {
        return null;
    }

    @Override
    public TopicDTO like(int id) {
        return null;
    }

    @Override
    public TopicDTO dislike(int id) {
        return null;
    }

    @Override
    public TopicDTO add(TopicDTO topic) throws TopicException {
        return null;
    }
}
