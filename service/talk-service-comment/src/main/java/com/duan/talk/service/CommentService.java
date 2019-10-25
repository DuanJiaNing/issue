package com.duan.talk.service;


import com.duan.talk.common.dto.CommentDTO;
import com.duan.talk.common.dto.PageInfo;
import com.duan.talk.common.exceptions.CommentException;
import com.github.pagehelper.Page;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public interface CommentService {

    CommentDTO add(CommentDTO comment) throws CommentException;

    Page<CommentDTO> listByTopic(int topicId, PageInfo pageInfo);

}
