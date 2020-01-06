package com.duan.issue.impl;

import com.duan.issue.base.dto.PageCondition;
import com.duan.issue.base.exceptions.InternalException;
import com.duan.issue.base.util.DataConverter;
import com.duan.issue.common.TopicStatus;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.entity.Topic;
import com.duan.issue.common.exceptions.TopicException;
import com.duan.issue.dao.TopicDao;
import com.duan.issue.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        Topic topic = topicDao.findById(id);
        return DataConverter.map(topic, TopicDTO.class);
    }

    @Override
    public TopicDTO like(int id) throws TopicException {
        return null;
    }

    @Override
    public TopicDTO dislike(int id) throws TopicException {
        return null;
    }

    @Override
    public TopicDTO add(String title, String notes) throws TopicException {
        if (title == null || StringUtils.isBlank(title)) {
            throw new TopicException("Fail to add topic: topic title can not be empty");
        }

        // TODO check exist by title
//        topicDao.

        Topic topic = new Topic();
        if (StringUtils.isNotBlank(notes)) {
            topic.setNotes(notes);
        }
        topic.setTitle(title);
        topic.setStatus(TopicStatus.FINE.ordinal());
        if (topicDao.insert(topic) != 1) {
            throw new TopicException("Fail to add topic", new InternalException("DB"));
        }

        return DataConverter.map(topic, TopicDTO.class);
    }

    @Override
    public PageInfo<TopicDTO> list(PageCondition pageCondition) {
        if (pageCondition == null || pageCondition.getPageNum() < 0 || pageCondition.getPageSize() <= 0) {
            // no page query is not allowed, set default to 0,10
            pageCondition = new PageCondition();
            pageCondition.setPageNum(0);
            pageCondition.setPageSize(10);
        }

        PageHelper.startPage(pageCondition.getPageNum(), pageCondition.getPageSize());
        List<Topic> pageList = topicDao.findAll();
        return DataConverter.page(pageList, TopicDTO.class);
    }
}
