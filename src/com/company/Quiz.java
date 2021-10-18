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
    public void displayContent() {
        System.out.println("Question: " + question);
    }
}
