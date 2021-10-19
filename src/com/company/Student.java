package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Student implements User{
    private final String ID;
    private final HashMap<Assessment, Submission> map;
    Student(String ID)
    {
        this.ID = ID;
        map = new HashMap<>();
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
    public String getID() {
        return ID;
    }

    @Override
    public void viewLec_material(LinkedList<Lecture_material> lecture_contents) {
        for(Lecture_material lec:lecture_contents) {
            lec.displayContent();
            System.out.println();
        }
    }

    @Override
    public boolean viewAssessment(LinkedList<Assessment> assessments, int param) {
        if(param==0)
        {
            boolean found = false;
            System.out.println("Open Assessments:");
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
            System.out.println("Closed Assessments:");
            boolean isAnythingPresent = false;
            for (int i = 0; i < assessments.size(); i++)
            {
                if (assessments.get(i).getIsClosed())
                {
                    System.out.print("ID: " + i + " ");
                    assessments.get(i).displayContent();
                    System.out.println("----------------");
                    found = true;
                    isAnythingPresent = true;
                }
            }
            if(!isAnythingPresent)
            {
                System.out.println("No Assignments present under this section");
            }
            System.out.println();
            return found;
        }
        else if(param==1)
        {
            for(int i=0; i<assessments.size(); i++)
            {
                System.out.print("ID: " + i + " ");
                assessments.get(i).displayContent();
                System.out.println("----------------");
            }
            return true;
        }
        else
        {
            boolean found = false;
            for (int i = 0; i < assessments.size(); i++)
            {
                if(!assessments.get(i).getIsClosed() && !map.containsKey(assessments.get(i)))
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
    public void viewComments(LinkedList<Comments> comments) {
        for(Comments comment: comments)
        {
            System.out.println(comment.getContent() + " - " + comment.getMadeBy());
            System.out.println(comment.getDate());
            System.out.println();
        }
    }

    public void submitAssessment(Assessment assessment, Submission sub)
    {
        map.put(assessment, sub);
    }

    public HashMap<Assessment, Submission> getMap() {
        return map;
    }

    public void viewGrades()
    {
        LinkedList<Submission> graded = new LinkedList<>();
        LinkedList<Submission> ungraded = new LinkedList<>();

        for(Map.Entry<Assessment, Submission> m : map.entrySet())
        {
            Submission sub = m.getValue();
            if(sub.isGraded())
                graded.add(sub);
            else
                ungraded.add(sub);
        }
        System.out.println("Graded submissions");
        for(Submission subs: graded)
        {
            System.out.println("Submission: " + subs.getStu_ans());
            System.out.println("Marks scored: " + subs.getMarks());
            System.out.println("Graded by: " + subs.getInstructor().getID());
            System.out.println();
        }
        System.out.println("----------------------------");
        System.out.println("Ungraded submissions");
        for(Submission subs: ungraded)
        {
            System.out.println("Submission: " + subs.getStu_ans());
        }
        System.out.println("----------------------------");
        System.out.println();
    }
}
