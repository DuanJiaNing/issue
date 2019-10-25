package com.duan.talk.api;

import com.duan.talk.common.ResultModel;
import com.duan.talk.common.dto.CommentDTO;
import com.duan.talk.common.exceptions.CommentException;
import com.duan.talk.service.CommentService;
import com.duan.talk.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Reference
    private CommentService commentService;

    @PostMapping
    public ResultModel<CommentDTO> add(@RequestBody CommentDTO comment) {
        if (StringUtils.isBlank(comment.getContent())) {
            return ResultUtils.fail("请输入内容");
        }

        try {
            comment = commentService.add(comment);
        } catch (CommentException e) {
            return ResultUtils.fail(e);
        }

        return ResultUtils.success(comment);
    }

    @PutMapping("/{commentId}/like")
    public ResultModel<CommentDTO> like(@PathVariable Integer commentId) {
        return null;
    }

    @PutMapping("/{commentId}/dislike")
    public ResultModel<CommentDTO> dislike(@PathVariable Integer commentId) {
        return null;
    }

}
