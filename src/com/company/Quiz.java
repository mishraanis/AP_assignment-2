package com.company;

public class Quiz implements Assessment{
    private final String question;
    private final int max_marks;
    private boolean isClosed;
    Quiz(String question)
    {
        this.question = question;
        this.max_marks = 1;
        this.isClosed = false;
    }

    @Override
    public String getProblem_Question() {
        return question;
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
        System.out.println("Question: " + question);
    }
}
