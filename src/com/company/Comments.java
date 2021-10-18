package com.company;

import java.util.Date;

public class Comments {
    private final String content;
    private String madeBy;
    Date date;
    Comments(String content, String madeBy)
    {
        this.content = content;
        this.madeBy = madeBy;
        date = java.util.Calendar.getInstance().getTime();
    }
}
