package com.company;

import java.util.Date;

public class Slide implements Lecture_material{
    private final String topic;
    private final String []content;
    private final Date date;
    private final int num_slides;
    private final String instructor_name;
    Slide(String topic, int num_slides, String []content, String instructor_name)
    {
        this.topic = topic;
        this.num_slides = num_slides;
        this.content = content;
        this.date = java.util.Calendar.getInstance().getTime();
        this.instructor_name = instructor_name;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public void displayContent() {
        System.out.println("Title: " + topic);
        for(int i=0; i<num_slides; i++)
            System.out.println("Slide " + (i+1) + ": " + content[i]);
        System.out.println("Number of slides: " + num_slides);
        System.out.println("Date of upload: " + date);
        System.out.println("Uploaded by: " + instructor_name);
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getInst_name() {
        return instructor_name;
    }

    public int getNum_slides() {
        return num_slides;
    }

    public String[] getContent() {
        return content;
    }
}
