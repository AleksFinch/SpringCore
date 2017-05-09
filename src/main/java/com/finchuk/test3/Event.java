package com.finchuk.test3;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Oleksandr_Finchuk on 5/3/2017.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date) {
        id = new Random().nextInt();
        this.date = date;
    }
    public Event(Date date, DateFormat dateFormat) {
        id = new Random().nextInt();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
