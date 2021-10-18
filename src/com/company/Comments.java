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
    public String getContent()
    {
        return content;
    }
    public String getMadeBy()
    {
        return madeBy;
    }
    public Date getDate()
    {
        return date;
    }
}
