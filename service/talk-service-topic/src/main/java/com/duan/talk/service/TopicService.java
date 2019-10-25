package com.duan.talk.service;


import com.duan.talk.common.dto.TopicDTO;
import com.duan.talk.common.exceptions.TopicException;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public interface TopicService {

    TopicDTO get(int id);

    TopicDTO add(TopicDTO topic) throws TopicException;

}
