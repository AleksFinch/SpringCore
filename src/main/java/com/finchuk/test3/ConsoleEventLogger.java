package com.finchuk.test3;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event);
    }
}
