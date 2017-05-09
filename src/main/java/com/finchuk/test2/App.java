package com.finchuk.test2;

import javafx.application.Application;
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


    public void logEvent(String msg){
        String message = msg.replaceAll(client.getId(),client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test2/spring.xml");
        App app = (App)ctx.getBean("app");
        //App app = ctx.getBean("app",App.class);
        //App app = ctx.getBean(App.class);
        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
    }
}
