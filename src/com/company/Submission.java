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
        instructor_name = "";
    }
    public void setGraded()
    {
        isGraded = true;
    }
    public void setMarks(int marks)
    {
        this.marks = marks;
    }
    public void setInstructor_name(String inst_name)
    {
        this.instructor_name = inst_name;
    }
}
