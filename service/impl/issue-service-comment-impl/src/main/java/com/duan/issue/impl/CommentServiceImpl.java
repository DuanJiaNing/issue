package com.duan.issue.impl;

import com.duan.issue.base.dto.PageCondition;
import com.duan.issue.base.util.DataConverter;
import com.duan.issue.common.dto.CommentDTO;
import com.duan.issue.common.entity.Comment;
import com.duan.issue.common.enums.CommentStatus;
import com.duan.issue.common.exceptions.CommentException;
import com.duan.issue.common.exceptions.IllegalStatusException;
import com.duan.issue.dao.CommentDao;
import com.duan.issue.service.CommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
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
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    private Comment getById(int id) throws CommentException {
        Comment comment = commentDao.findById(id);
        if (comment == null) {
            throw new CommentException("Comment is not exist with id=" + id);
        }

        return comment;
    }

    private void update(Comment ct) throws CommentException {
        if (commentDao.update(ct) != 1) {
            throw new CommentException("Fail to update comment", new InternalException("DB"));
        }
    }

    @Override
    public CommentDTO add(String content, int topicId) throws CommentException {
        if (content == null || StringUtils.isBlank(content)) {
            throw new CommentException("Fail to add comment: comment content can not be empty");
        }

        // don't check if topic is not exist or in DELETE status to reduce rely on other parts of the monomer system,
        // caller should check by self
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setTopicId(topicId);
        comment.setLike(0);
        comment.setDislike(0);
        comment.setStatus(CommentStatus.FINE.ordinal());
        if (commentDao.insert(comment) != 1) {
            throw new CommentException("Fail to add comment", new InternalException("DB"));
        }

        return DataConverter.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO like(int id) throws CommentException {
        Comment comment = getById(id);
        if (CommentStatus.DELETED.ordinal() == comment.getStatus()) {
            throw new IllegalStatusException(CommentStatus.DELETED);
        }

        Comment ut = new Comment();
        ut.setId(comment.getId());
        int newLike = comment.getLike() + 1;
        ut.setLike(newLike);
        update(ut);

        return get(id);
    }

    @Override
    public CommentDTO get(int id) {
        Comment comment = commentDao.findById(id);
        return DataConverter.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO dislike(int id) throws CommentException {
        Comment comment = getById(id);
        if (CommentStatus.DELETED.ordinal() == comment.getStatus()) {
            throw new IllegalStatusException(CommentStatus.DELETED);
        }

        Comment ut = new Comment();
        ut.setId(comment.getId());
        int newDislike = comment.getDislike() + 1;
        ut.setLike(newDislike);
        update(ut);

        return get(id);
    }

    @Override
    public Page<CommentDTO> listByTopic(int topicId, PageCondition pageCondition) {
        if (pageCondition == null || pageCondition.getCurrentPage() < 0 || pageCondition.getPageSize() <= 0) {
            // no page query is not allowed, set default to 0,10
            pageCondition = new PageCondition();
            pageCondition.setCurrentPage(0);
            pageCondition.setPageSize(10);
        }

        PageHelper.startPage(pageCondition.getCurrentPage(), pageCondition.getPageSize());
        List<Comment> pageList = commentDao.findByTopicId(topicId);
        return DataConverter.page(pageList, CommentDTO.class);
    }
}
