package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class Student implements User{
    private final String ID;
    private HashMap<Assessment, Submission> map;
    Student(String ID)
    {
        this.ID = ID;
        map = new HashMap<Assessment, Submission>();
    }

    @Override
    public void showMenu() {
        System.out.println("""
                STUDENT MENU
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout""");
    }

    @Override
    public void viewLec_material(LinkedList<Lecture_material> lecture_contents) {
        for(Lecture_material lec:lecture_contents)
            lec.displayContent();
    }

    @Override
    public void viewAssessment(LinkedList<Assessment> assessments) {
        for(int i=0; i<assessments.size(); i++){
            System.out.print("ID: " + i + " ");
            assessments.get(i).displayContent();
        }
    }

    @Override
    public void viewComments(LinkedList<Comments> comments) {

    }

    @Override
    public void addComments(Comments comment) {

    }
}
