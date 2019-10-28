package com.duan.issue.impl;

import com.duan.issue.common.dto.CommentDTO;
import com.duan.issue.common.dto.PageInfo;
import com.duan.issue.common.exceptions.CommentException;
import com.duan.issue.dao.CommentDao;
import com.duan.issue.service.CommentService;
import com.github.pagehelper.Page;
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

    @Override
    public CommentDTO add(CommentDTO comment) throws CommentException {
        return null;
    }

    @Override
    public CommentDTO like(int id) {
        return null;
    }

    @Override
    public CommentDTO get(int id) {
        return null;
    }

    @Override
    public CommentDTO dislike(int id) {
        return null;
    }

    @Override
    public Page<CommentDTO> listByTopic(int topicId, PageInfo pageInfo) {
        return null;
    }
}
