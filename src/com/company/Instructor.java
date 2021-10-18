package com.company;

import java.util.LinkedList;

public class Instructor implements User{
    private final String ID;
    Instructor(String ID)
    {
        this.ID = ID;
    }

    public void addMaterial(LinkedList<Lecture_material> lecture_contents, Lecture_material content)
    {
        lecture_contents.add(content);
    }

    @Override
    public void showMenu() {
        System.out.println("""
                INSTRUCTOR MENU
                1. Add class material
                2. Add assessments
                3. View lecture materials
                4. View assessments
                5. Grade assessments
                6. Close assessment
                7. View comments
                8. Add comments
                9. Logout""");
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
