package com.duan.issue.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/10/31.
 *
 * @author DuanJiaNing
 */
@Data
@Component
@ConfigurationProperties(prefix = "config")
public class Config {

    private Topic topic;
    private Comment comment;
    private Manage manage;

    @Data
    public static class Topic {
        private int wordLimit;
        private int notesLimit;
    }

    @Data
    public static class Comment {
        private int wordLimit;
    }

    @Data
    public static class Manage {
        private int proposalWordLimit;
    }

}
