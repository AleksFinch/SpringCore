package com.finchuk.test5.loggers;


import com.finchuk.test5.Event;

import java.util.ArrayList;
import java.util.Collection;

/**
* Created by Oleksandr_Finchuk on 5/3/2017.
*/
public class CombinedEventLogger implements EventLogger {
   Collection<EventLogger> loggers = new ArrayList<EventLogger>();

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
       for (EventLogger logger:
            loggers) {
           logger.logEvent(event);
       }
   }





}
