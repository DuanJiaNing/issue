package com.duan.issue.api;

import com.duan.issue.common.ResultModel;
import com.duan.issue.common.dto.CommentDTO;
import com.duan.issue.common.dto.TopicDTO;
import com.duan.issue.common.exceptions.TopicException;
import com.duan.issue.config.Config;
import com.duan.issue.service.CommentService;
import com.duan.issue.service.TopicService;
import com.duan.issue.utils.ResultUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private Config config;

    @PostMapping
    public ResultModel<TopicDTO> add(@RequestParam String title, @RequestParam String notes) {
        if (StringUtils.isBlank(title)) {
            return ResultUtils.error("请输入标题");
        }

        Config.Topic topicC = config.topic();
        if (title.length() > topicC.getWordLimit()) {
            return ResultUtils.error("字数需要控制在 " + topicC.getWordLimit() + " 字以内");
        }

        try {
            TopicDTO topic = topicService.add(title, notes);
            return ResultUtils.success(topic);
        } catch (TopicException e) {
            return ResultUtils.fail(e);
        }
    }

    @GetMapping("/{topicId}")
    public ResultModel<TopicDTO> get(@PathVariable Integer topicId) {
        TopicDTO topic = topicService.get(topicId);
        return ResultUtils.success(topic);
    }

    @PutMapping("/{topicId}/like")
    public ResultModel<TopicDTO> like(@PathVariable Integer topicId) {
        try {
            TopicDTO topic = topicService.like(topicId);
            return ResultUtils.success(topic);
        } catch (TopicException e) {
            return ResultUtils.fail(e);
        }
    }

    @PutMapping("/{topicId}/dislike")
    public ResultModel<TopicDTO> dislike(@PathVariable Integer topicId) {
        try {
            TopicDTO topic = topicService.dislike(topicId);
            return ResultUtils.success(topic);
        } catch (TopicException e) {
            return ResultUtils.fail(e);
        }
    }

    @GetMapping("/{topicId}/comments")
    public ResultModel<Page<CommentDTO>> allTopicComments(@PathVariable Integer topicId,
                                                          @RequestParam Integer currentPage,
                                                          @RequestParam Integer pageSize) {
        if (currentPage < 0 || pageSize <= 0) {
            return ResultUtils.fail("currentPage or pageSize incorrect", HttpStatus.BAD_REQUEST);
        }

        Page<CommentDTO> page = commentService.listByTopic(topicId, new PageCondition(currentPage, pageSize));
        if (ResultUtils.emptyPage(page)) {
            return ResultUtils.success(null);
        }

        return ResultUtils.success(page);
    }

}
