package com.company;

import java.util.LinkedList;

public class Course {
    private LinkedList<Instructor> instructors;
    private LinkedList<Student> students;
    private LinkedList<Lecture_material> lecture_contents;
    private LinkedList<Assessment> assessments;
    private LinkedList<Comments> comments;
    Course()
    {
        instructors = new LinkedList<>();
        students = new LinkedList<>();
        lecture_contents = new LinkedList<>();
        comments = new LinkedList<>();
    }
    void Initialise()
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
    void addLecture(Lecture_material content, Instructor inst)
    {
        inst.addMaterial(lecture_contents, content);
    }
    void showLectures(User user)
    {
        user.viewLec_material(lecture_contents);
    }
    void showAssessments(User user)
    {
        user.viewAssessment(assessments);
    }
    void showComments(User user)
    {
        user.viewComments(comments);
    }
    void GradeAssessment(Instructor instructor)
}
