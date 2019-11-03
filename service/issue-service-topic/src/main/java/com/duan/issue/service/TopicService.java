package com.duan.issue.service;


import com.duan.issue.base.service.Service;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.exceptions.TopicException;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public interface TopicService extends Service<TopicDTO> {

    TopicDTO like(int id) throws TopicException;

    TopicDTO dislike(int id) throws TopicException;

    TopicDTO add(String topic, String notes) throws TopicException;

}
