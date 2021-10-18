package com.company;

import java.util.LinkedList;

public class Instructor implements User{
    private final String ID;
    Instructor(String ID)
    {
        this.ID = ID;
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

    public void addLec_Material(LinkedList<Lecture_material> lecture_contents, Lecture_material content)
    {
        lecture_contents.add(content);
    }

    @Override
    public void viewLec_material(LinkedList<Lecture_material> lecture_contents) {
        for(Lecture_material lec:lecture_contents) {
            lec.displayContent();
            System.out.println();
        }
    }

    public void uploadAssessment(LinkedList<Assessment> assessments, Assessment assessment)
    {
        assessments.add(assessment);
    }

    @Override
    public void viewAssessment(LinkedList<Assessment> assessments) {
        for(int i=0; i<assessments.size(); i++){
            if(!assessments.get(i).getIsClosed())
            {
                System.out.print("ID: " + i + " ");
                assessments.get(i).displayContent();
                System.out.println("----------------");
            }
        }
    }

    @Override
    public void addComments(LinkedList<Comments> comments, Comments comment) {
        comments.add(comment);
    }

    @Override
    public void viewComments(LinkedList<Comments> comments) {
        for(Comments comment: comments)
        {
            System.out.println(comment.getContent() + " - " + comment.getMadeBy());
            System.out.println(comment.getDate());
        }
    }

    public void closeAssessment(LinkedList<Assessment> assessments, Assessment assessment)
    {
        for(Assessment assmnt: assessments)
        {
            if(assmnt == assessment && !assmnt.getIsClosed())
            {
                assmnt.setIsClosed(true);
                break;
            }
            else if(assmnt == assessment && assmnt.getIsClosed())
            {
                System.out.println("Assignment has been closed already");
                break;
            }
        }
    }

}
