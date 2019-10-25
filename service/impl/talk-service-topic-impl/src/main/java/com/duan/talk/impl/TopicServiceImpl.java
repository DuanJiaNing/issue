package com.duan.talk.impl;

import com.duan.talk.common.dto.TopicDTO;
import com.duan.talk.common.exceptions.TopicException;
import com.duan.talk.dao.TopicDao;
import com.duan.talk.service.TopicService;
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
    public TopicDTO add(TopicDTO topic) throws TopicException {
        return null;
    }
}
