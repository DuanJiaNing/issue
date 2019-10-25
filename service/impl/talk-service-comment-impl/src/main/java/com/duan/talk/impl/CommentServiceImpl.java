package com.duan.talk.impl;

import com.duan.talk.dao.CommentDao;
import com.duan.talk.service.CommentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao topicDao;

}
