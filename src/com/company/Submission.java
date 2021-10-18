package com.company;

public class Submission {
    private String fileName;
    private boolean isGraded;
    private int marks;
    private String instructor_name;
    Submission(String filename)
    {
        this.fileName = filename;
        this.isGraded = false;
        this.instructor_name = "";
        this.marks = -1;
    }
    public void setGraded(int marks, String instructor_name)
    {
        isGraded = true;
        this.marks = marks;
        this.instructor_name = instructor_name;
    }
}
