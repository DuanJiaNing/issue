package com.duan.issue.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 2019/10/31.
 *
 * @author DuanJiaNing
 */
@Configuration
@PropertySource("classpath:config.yml")
public class Config {

    // ------------------------------------------------------- topic
    @Data
    public static class Topic {
        private int wordLimit;
    }

    @ConfigurationProperties(prefix = "config.topic")
    public Topic topic() {
        return new Topic();
    }

    // ------------------------------------------------------- comment
    @Data
    public static class Comment {
        private int wordLimit;
    }

    @ConfigurationProperties(prefix = "config.comment")
    public Comment comment() {
        return new Comment();
    }

    // ------------------------------------------------------- manage
    @Data
    public static class Manage {
        private int proposalWordLimit;
    }

    @ConfigurationProperties(prefix = "config.manage")
    public Manage manage() {
        return new Manage();
    }

}
