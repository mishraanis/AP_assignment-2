package com.company;

public interface Assessment {
    public String getProblem_Question();
    public int getMaxMarks();
    public boolean getIsClosed();
    public void setIsClosed(boolean val);
    public void displayContent();
}
