package com.projects.core.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class LogExecutionTimeConfiguration {
    @Bean
    public LogExecutionTimeAspect getLogExecutionTime() {
        return new LogExecutionTimeAspect();
    }
}
