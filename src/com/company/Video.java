package com.company;

import java.util.Date;

public class Video implements Lecture_material {
    private final String topic;
    private final String vid_file;
    private final Date date;
    private final String inst_name;
    Video(String topic, String vid_file, String inst_name)
    {
        this.topic = topic;
        this.vid_file = vid_file;
        this.date = java.util.Calendar.getInstance().getTime();
        this.inst_name = inst_name;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public void displayContent() {
        System.out.println("Title: " + topic);
        System.out.println("Video file: " + vid_file);
        System.out.println("Date of upload: " + date);
        System.out.println("Uploaded by: " + inst_name);
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getInst_name() {
        return inst_name;
    }

    public String getVid_file() {
        return vid_file;
    }
}
