package com.company;

public class Assignment implements Assessment{
    private final String prob_statement;
    private final int max_marks;
    private boolean isClosed;
    Assignment(String prob_statement, int max_marks)
    {
        this.prob_statement = prob_statement;
        this.max_marks = max_marks;
        this.isClosed = false;
    }

    @Override
    public void displayContent() {
        System.out.println("Assignment: " + prob_statement + " Max Marks: " + max_marks);
    }
}
