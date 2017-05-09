package com.finchuk.annotations.loggers;

import com.finchuk.annotations.Event;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public interface EventLogger {
    void logEvent(Event event);
}
