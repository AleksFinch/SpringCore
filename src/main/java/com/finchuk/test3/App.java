package com.finchuk.test3;

import org.springframework.context.ApplicationContext;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test3/spring.xml");
        App app = (App)ctx.getBean("app");
        //App app = ctx.getBean("app",App.class);
        //App app = ctx.getBean(App.class);
        Event event = ctx.getBean("event",Event.class);
        app.logEvent(event);
    }
}
