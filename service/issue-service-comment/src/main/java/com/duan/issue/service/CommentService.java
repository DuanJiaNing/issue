package com.duan.issue.service;


import com.duan.issue.common.dto.CommentDTO;
import com.duan.issue.common.dto.PageInfo;
import com.duan.issue.common.exceptions.CommentException;
import com.github.pagehelper.Page;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public interface CommentService {

    CommentDTO add(CommentDTO comment) throws CommentException;

    CommentDTO like(int id);

    CommentDTO get(int id);

    CommentDTO dislike(int id);

    Page<CommentDTO> listByTopic(int topicId, PageInfo pageInfo);

}
