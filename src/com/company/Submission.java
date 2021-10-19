package com.company;

public class Submission {
    private final String stu_ans;
    private boolean isGraded;
    private int marks;
    private Instructor instructor;
    Submission(String stu_ans)
    {
        this.stu_ans = stu_ans;
        this.isGraded = false;
        this.instructor = null;
        this.marks = -1;
    }

    public String getStu_ans() {
        return stu_ans;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public int getMarks() {
        return marks;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setGraded(int marks, Instructor instructor) {
        isGraded = true;
        this.marks = marks;
        this.instructor = instructor;
    }
}
