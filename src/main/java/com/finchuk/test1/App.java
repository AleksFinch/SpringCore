package com.finchuk.test1;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class App {
    Client client;
    ConsoleEventLogger eventLogger;

    public void logEvent(String msg){
        String message = msg.replaceAll(client.getId(),client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1","John Smith");
        app.eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1");
    }
}
