package com.duan.issue.impl;

import com.duan.issue.base.exceptions.InternalException;
import com.duan.issue.base.util.DataConverter;
import com.duan.issue.common.TopicStatus;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.entity.Topic;
import com.duan.issue.common.exceptions.IllegalStatusException;
import com.duan.issue.common.exceptions.TopicException;
import com.duan.issue.dao.TopicDao;
import com.duan.issue.service.TopicService;
import org.apache.commons.lang3.StringUtils;
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

    private Topic getById(int id) throws TopicException {
        Topic topic = topicDao.findById(id);
        if (topic == null) {
            throw new TopicException("Topic is not exist with id=" + id);
        }

        return topic;
    }

    private void update(Topic tp) throws TopicException {
        if (topicDao.update(tp) != 1) {
            throw new TopicException("Fail to update topic", new InternalException("DB"));
        }
    }

    @Override
    public TopicDTO get(int id) {
        Topic topic = topicDao.findById(id);
        return DataConverter.map(topic, TopicDTO.class);
    }

    @Override
    public TopicDTO like(int id) throws TopicException {
        Topic topic = getById(id);
        if (TopicStatus.DELETED.ordinal() == topic.getStatus()) {
            throw new IllegalStatusException(TopicStatus.DELETED);
        }

        Topic ut = new Topic();
        ut.setId(topic.getId());
        int newLike = topic.getLike() + 1;
        ut.setLike(newLike);
        update(ut);

        return get(id);
    }

    @Override
    public TopicDTO dislike(int id) throws TopicException {
        Topic topic = getById(id);
        if (TopicStatus.DELETED.ordinal() == topic.getStatus()) {
            throw new IllegalStatusException(TopicStatus.DELETED);
        }

        Topic ut = new Topic();
        ut.setId(topic.getId());
        int newDislike = topic.getDislike() + 1;
        ut.setDislike(newDislike);
        update(ut);

        return get(id);
    }

    @Override
    public TopicDTO add(String title, String notes) throws TopicException {
        if (title == null || StringUtils.isBlank(title)) {
            throw new TopicException("Fail to add topic: topic title can not be empty");
        }

        // TODO check exist by title

        Topic topic = new Topic();
        if (StringUtils.isNotBlank(notes)) {
            topic.setNotes(notes);
        }
        topic.setTitle(title);
        topic.setStatus(TopicStatus.FINE.ordinal());
        topic.setLike(0);
        topic.setDislike(0);
        if (topicDao.insert(topic) != 1) {
            throw new TopicException("Fail to add topic", new InternalException("DB"));
        }

        return DataConverter.map(topic, TopicDTO.class);
    }
}
