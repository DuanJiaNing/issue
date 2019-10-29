package com.duan.issue.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Data
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 683131330933446817L;
    private Integer status;
    private String content;
    private Integer like;
    private Integer topicId;
    private Integer dislike;

}
