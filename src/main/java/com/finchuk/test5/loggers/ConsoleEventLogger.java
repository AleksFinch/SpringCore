package com.finchuk.test5.loggers;

import com.finchuk.test5.Event;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event);
    }
}
