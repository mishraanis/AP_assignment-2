package com.company;

import java.util.LinkedList;

public interface User {
    void showMenu();
    String getID();
    void viewLec_material(LinkedList<Lecture_material> lecture_contents);
    boolean viewAssessment(LinkedList<Assessment> assessments, int param);
    void viewComments(LinkedList<Comments> comments);
    void addComments(LinkedList<Comments> comments, Comments comment);
}