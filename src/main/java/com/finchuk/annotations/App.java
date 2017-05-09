package com.finchuk.annotations;

import com.finchuk.annotations.config.AppConfig;
import com.finchuk.annotations.loggers.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
@Component
public class App {
    Client client;
    Map<EventType,EventLogger> eventLoggerMap;
    EventLogger defaultLogger;

    @Autowired
    public App(Client client, @Qualifier(value = "cacheFileEventLogger") EventLogger defaultLogger,
               @Qualifier(value = "type_logger")Map<EventType, EventLogger> eventLoggerMap) {

        this.client = client;
        this.eventLoggerMap = eventLoggerMap;
        this.defaultLogger = defaultLogger;
    }

    public void logEvent(Event event, EventType type){
        event.setMsg(event.getMsg().replaceAll(client.getId(),client.getFullName()));
        eventLoggerMap.getOrDefault(type,defaultLogger).logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.registerShutdownHook();

        App app = (App)ctx.getBean(App.class);
        Event event = ctx.getBean(Event.class);
        app.logEvent(event,null);
        event = ctx.getBean(Event.class);
        app.logEvent(event, EventType.ERROR);
        event = ctx.getBean(Event.class);
        app.logEvent(event, EventType.INFO);
    }
}
