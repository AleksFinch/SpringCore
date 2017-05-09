package com.finchuk.annotations.config;

import com.finchuk.annotations.loggers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by olexandr on 09.05.17.
 */
@Configuration
public class LoggersConfig {
    @Autowired
    ApplicationContext context;

    @Bean(name = "cacheFileEventLogger")
    public CacheFileEventLogger getCacheFileEventLogger(){
        return new CacheFileEventLogger();
    }

    @Bean
    public CombinedEventLogger getCombinedEventLogger(@Qualifier(value="combLoggers") List<EventLogger> eventLoggers){
        return new CombinedEventLogger(eventLoggers);
    }

    @Bean
    public ConsoleEventLogger getConsoleEventLogger(){
        return new ConsoleEventLogger();
    }

    @Bean(name = "combLoggers")
    public List<EventLogger> getEventLoggers(){
       return Arrays.asList(
                context.getBean(ConsoleEventLogger.class),
                context.getBean("fileEventLogger",FileEventLogger.class),
                context.getBean(CacheFileEventLogger.class)
        );
    }
}
