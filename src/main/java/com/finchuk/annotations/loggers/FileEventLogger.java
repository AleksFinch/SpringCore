package com.finchuk.annotations.loggers;

import com.finchuk.annotations.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
@Component("fileEventLogger")
public class FileEventLogger implements EventLogger {
    protected File file;
    @Value("src/main/resources/test6/tmp6.txt")
    protected String filename;

    @PostConstruct
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
