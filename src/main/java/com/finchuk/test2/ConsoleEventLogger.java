package com.finchuk.test2;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String msg){
        System.out.println(msg);
    }
}
