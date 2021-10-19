package com.company;

import java.util.LinkedList;

public class Course {
    private final LinkedList<Instructor> instructors;
    private final LinkedList<Student> students;
    private final LinkedList<Lecture_material> lecture_contents;
    private final LinkedList<Assessment> assessments;
    private final LinkedList<Comments> comments;
    Course()
    {
        instructors = new LinkedList<>();
        students = new LinkedList<>();
        lecture_contents = new LinkedList<>();
        comments = new LinkedList<>();
        assessments = new LinkedList<>();
    }
    public void Initialise()
    {
        Student S0 = new Student("S0");
        Student S1 = new Student("S1");
        Student S2 = new Student("S2");
        students.add(S0);
        students.add(S1);
        students.add(S2);
        Instructor I0 = new Instructor("I0");
        Instructor I1 = new Instructor("I1");
        instructors.add(I0);
        instructors.add(I1);
    }

    public LinkedList<Instructor> getInstructors() {
        return instructors;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public LinkedList<Assessment> getAssessments() {
        return assessments;
    }

    void addLecture(Lecture_material content, Instructor instructor)
    {
        instructor.addLec_Material(lecture_contents, content);
    }

    void showLectures(User user)
    {
        user.viewLec_material(lecture_contents);
    }

    void addAssessment(Instructor instructor, Assessment assessment)
    {
        instructor.uploadAssessment(assessments, assessment);
    }

    boolean showAssessments(User user, int param)
    {
        return user.viewAssessment(assessments, param);
    }

    void submitAssessment(Student student, Assessment assessment, Submission sub)
    {
        student.submitAssessment(assessment, sub);
    }

    boolean showStudents_with_Assessment(Assessment assessment)
    {
        boolean found = false;
        for(int i=0; i<students.size(); i++)
        {
            Student student = students.get(i);
            if(student.getMap().containsKey(assessment) && !student.getMap().get(assessment).isGraded())
            {
                System.out.println(i + ". " + student.getID());
                found = true;
            }
        }
        return found;
    }

    void gradeAssessment(Instructor instructor, Student student, Assessment assessment, int marks)
    {
        instructor.Assigning_grade(student, assessment, marks);
    }

    void viewGrades(Student student)
    {
        student.viewGrades();
    }

    void addComment(User user, Comments comment)
    {
        user.addComments(comments, comment);
    }

    void showComments(User user)
    {
        user.viewComments(comments);
    }

    void CloseAssessment(Instructor instructor, Assessment assessment)
    {
        instructor.closeAssessment(assessments, assessment);
    }
}
