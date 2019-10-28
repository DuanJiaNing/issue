package com.duan.issue.api;

import com.duan.issue.common.ResultModel;
import com.duan.issue.common.dto.CommentDTO;
import com.duan.issue.common.dto.PageInfo;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.exceptions.TopicException;
import com.duan.issue.service.CommentService;
import com.duan.issue.service.TopicService;
import com.duan.issue.utils.ResultUtils;
import com.github.pagehelper.Page;
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
@RequestMapping("/topic")
public class TopicController {

    @Reference
    private TopicService topicService;

    @Reference
    private CommentService commentService;

    @PostMapping
    public ResultModel<TopicDTO> add(@RequestBody TopicDTO topic) {
        if (StringUtils.isBlank(topic.getTitle())) {
            return ResultUtils.fail("请输入标题");
        }

        try {
            topic = topicService.add(topic);
        } catch (TopicException e) {
            return ResultUtils.fail(e);
        }

        return ResultUtils.success(topic);
    }

    @GetMapping("/{topicId}")
    public ResultModel<TopicDTO> get(@PathVariable Integer topicId) {
        TopicDTO topic = topicService.get(topicId);
        return ResultUtils.success(topic);
    }

    @PutMapping("/{topicId}/like")
    public ResultModel<TopicDTO> like(@PathVariable Integer topicId) {
        TopicDTO topic = topicService.like(topicId);
        return ResultUtils.success(topic);
    }

    @PutMapping("/{topicId}/dislike")
    public ResultModel<TopicDTO> dislike(@PathVariable Integer topicId) {
        TopicDTO topic = topicService.dislike(topicId);
        return ResultUtils.success(topic);
    }

    @GetMapping("/{topicId}/comments")
    public ResultModel<Page<CommentDTO>> allTopicComments(@PathVariable Integer topicId,
                                                          @RequestParam Integer currentPage,
                                                          @RequestParam Integer pageSize) {
        if (currentPage < 0 || pageSize <= 0) {
            return ResultUtils.fail("参数错误");
        }

        Page<CommentDTO> page = commentService.listByTopic(topicId, new PageInfo(currentPage, pageSize));
        if (ResultUtils.emptyPage(page)) {
            return ResultUtils.success(null);
        }

        return ResultUtils.success(page);
    }

}
