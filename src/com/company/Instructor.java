package com.company;

import java.util.LinkedList;

public class Instructor implements User{
    private final String ID;
    Instructor(String ID)
    {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return ID;
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
    public boolean viewAssessment(LinkedList<Assessment> assessments, int param)
    {
        if(param==0)
        {
            boolean found = false;
            System.out.println("Open Assessments");
            for (int i = 0; i < assessments.size(); i++) {
                if (!assessments.get(i).getIsClosed()) {
                    System.out.print("ID: " + i + " ");
                    assessments.get(i).displayContent();
                    System.out.println("----------------");
                    found = true;
                }
            }
            System.out.println("Closed Assessments");
            for (int i = 0; i < assessments.size(); i++) {
                if (assessments.get(i).getIsClosed()) {
                    System.out.print("ID: " + i + " ");
                    assessments.get(i).displayContent();
                    System.out.println("----------------");
                    found = true;
                }
            }
            return found;
        }
        else if(param==1)
        {
            if(assessments.size()>0)
            {
                System.out.println("List of Assessments");
                for (int i = 0; i < assessments.size(); i++) {
                    System.out.print("ID: " + i + " ");
                    assessments.get(i).displayContent();
                    System.out.println("----------------");
                }
                return true;
            }
            else
                return false;
        }
        else
        {
            boolean found = false;
            for (int i = 0; i < assessments.size(); i++)
            {
                if (!assessments.get(i).getIsClosed())
                {
                    System.out.print("ID: " + i + " ");
                    assessments.get(i).displayContent();
                    System.out.println("----------------");
                    found = true;
                }
            }
            return found;
        }
    }

    @Override
    public void addComments(LinkedList<Comments> comments, Comments comment) {
        comments.add(comment);
    }

    @Override
    public void viewComments(LinkedList<Comments> comments)
    {
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
            if(assmnt == assessment)
            {
                assmnt.setIsClosed(true);
                break;
            }
        }
    }

}
