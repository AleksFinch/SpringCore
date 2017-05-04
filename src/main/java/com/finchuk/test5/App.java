package com.finchuk.test5;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class App {
    Client client;
    Map<EventType,EventLogger> eventLoggerMap;
    EventLogger defaultLogger;
    public App() {
    }

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> eventLoggerMap) {

        this.client = client;
        this.eventLoggerMap = eventLoggerMap;
        this.defaultLogger = defaultLogger;
    }

    public void logEvent(Event event, EventType type){
        event.setMsg(event.getMsg().replaceAll(client.getId(),client.getFullName()));
        eventLoggerMap.getOrDefault(type,defaultLogger).logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("test5/spring.xml");
        ctx.registerShutdownHook();

        App app = (App)ctx.getBean("app");
        Event event = ctx.getBean("event",Event.class);
        app.logEvent(event,null);
        event = ctx.getBean("event",Event.class);
        app.logEvent(event, EventType.ERROR);
        event = ctx.getBean("event",Event.class);
        app.logEvent(event, EventType.INFO);
    }
}
