package com.duan.issue.service;


import com.duan.issue.common.dto.CommentDTO;
import com.duan.issue.common.dto.PageCondition;
import com.duan.issue.common.exceptions.CommentException;
import com.github.pagehelper.Page;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public interface CommentService {

    CommentDTO add(String content, int topicId) throws CommentException;

    CommentDTO like(int id) throws CommentException;

    CommentDTO get(int id);

    CommentDTO dislike(int id) throws CommentException;

    Page<CommentDTO> listByTopic(int topicId, PageCondition pageCondition);

}
