package com.finchuk.test4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class App {
    Client client;
    EventLogger eventLogger;
    public App() {
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }


    public void logEvent(Event event){
        event.setMsg(event.getMsg().replaceAll(client.getId(),client.getFullName()));
        eventLogger.logEvent(event);
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("test4/spring.xml");
        ctx.registerShutdownHook();

        App app = (App)ctx.getBean("app");
        Event event = ctx.getBean("event",Event.class);
        app.logEvent(event);
        event = ctx.getBean("event",Event.class);
        app.logEvent(event);
        event = ctx.getBean("event",Event.class);
        app.logEvent(event);
    }
}
