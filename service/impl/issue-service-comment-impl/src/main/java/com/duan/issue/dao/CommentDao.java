package com.duan.issue.dao;

import com.duan.issue.common.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Repository
public interface CommentDao extends BaseDao<Comment> {

    Comment findById(int id);

    List<Comment> findByTopicId(int topicId);
}
