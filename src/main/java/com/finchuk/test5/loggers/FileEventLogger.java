package com.finchuk.test5.loggers;

import com.finchuk.test5.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class FileEventLogger implements EventLogger {
    protected File file;
    protected String filename;
    public void init(){
        file = new File(filename);
        if (!file.canWrite()){
            throw new RuntimeException("access denied!");
        }
    }
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file,event.toString()+"\n",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
