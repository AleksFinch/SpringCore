package com.finchuk.test5;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<Event>();

    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }

    }

    private void writeEventsFromCache() {
        try {
            for (Event ev :
                    cache) {

                FileUtils.writeStringToFile(file, ev.toString()+"\n", true);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
