package com.finchuk.test4;


 import java.util.ArrayList;
 import java.util.Collection;

 /**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class CombinedEventLogger implements EventLogger {
    Collection<EventLogger> loggers = new ArrayList<EventLogger>();

    public void logEvent(Event event) {
        for (EventLogger logger:
             loggers) {
            logger.logEvent(event);
        }
    }



}
