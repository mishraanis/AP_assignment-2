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
    public String getProblem_Question() {
        return prob_statement;
    }

    @Override
    public int getMaxMarks() {
        return max_marks;
    }

    @Override
    public boolean getIsClosed() {
        return isClosed;
    }

    @Override
    public void setIsClosed(boolean val) {
        this.isClosed = val;
    }

    @Override
    public void displayContent() {
        System.out.println("Assignment: " + prob_statement + " Max Marks: " + max_marks);
    }
}
