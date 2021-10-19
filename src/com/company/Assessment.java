package com.company;

public interface Assessment {
    String getProblem_Question();
    int getMaxMarks();
    boolean getIsClosed();
    void setIsClosed(boolean val);
    void displayContent();
}
