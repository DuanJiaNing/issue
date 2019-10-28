package com.duan.issue.service;


import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.exceptions.TopicException;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public interface TopicService {

    TopicDTO get(int id);

    TopicDTO like(int id);

    TopicDTO dislike(int id);

    TopicDTO add(TopicDTO topic) throws TopicException;

}
