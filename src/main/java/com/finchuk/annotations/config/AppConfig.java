package com.finchuk.annotations.config;

import com.finchuk.annotations.*;
import com.finchuk.annotations.loggers.CombinedEventLogger;
import com.finchuk.annotations.loggers.ConsoleEventLogger;
import com.finchuk.annotations.loggers.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by olexandr on 09.05.17.
 */
@ComponentScan(basePackages = {"com.finchuk.annotations"})
@Import({LoggersConfig.class,PropConfig.class})
public class AppConfig {
    @Autowired
    ApplicationContext context;

    @Bean
    public DateFormat getDateFormat(){
        return DateFormat.getDateTimeInstance();
    }

    @Bean
    public Date getDate(){
        return new Date();
    }

    @Bean("type_logger")
    public Map<EventType,EventLogger> getEventTypeEventLoggerMap(){
        Map<EventType,EventLogger> map = new HashMap<>();
        map.put(EventType.ERROR,context.getBean(CombinedEventLogger.class));
        map.put(EventType.INFO,context.getBean(ConsoleEventLogger.class));

        return map;
    }
}
