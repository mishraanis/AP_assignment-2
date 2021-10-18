package com.company;

import java.util.LinkedList;

public interface User {
    public void showMenu();
    public void viewLec_material(LinkedList<Lecture_material> lecture_contents);
    public void viewAssessment(LinkedList<Assessment> assessments);
    public void viewComments(LinkedList<Comments> comments);
    public void addComments(LinkedList<Comments> comments, Comments comment);
}