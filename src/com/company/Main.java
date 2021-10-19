package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void instructor(Course course, Scanner sc) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Instructors:");
        LinkedList<Instructor> instructors = course.getInstructors();
        for(int i=0; i<instructors.size(); i++)
        {
            System.out.println(i + " - " + instructors.get(i).getID());
        }
        System.out.print("Choose id: ");
        int ID = sc.nextInt();
        Instructor curr_instructor = instructors.get(ID);
        System.out.println("Welcome " + curr_instructor.getID());
        curr_instructor.showMenu();
        String input = br.readLine();
        while(!input.equals("9"))
        {
            switch (input)
            {
                case "1":
                    System.out.println("1. Add Lecture Slide\n" +
                            "2. Add Lecture Video");
                    int n = sc.nextInt();

                    if(n == 1)
                    {
                        System.out.print("Enter topic of slides: ");
                        String topic = br.readLine();
                        System.out.print("Enter number of slides:");
                        int num_slides = sc.nextInt();
                        System.out.println("Enter content of slides");
                        String []content = new String[num_slides];
                        for(int i=0; i<num_slides; i++)
                        {
                            int temp = i+1;
                            System.out.print("Content of slide " + temp + ": ");
                            content[i] = br.readLine();
                        }
                        Slide slide = new Slide(topic, num_slides, content, curr_instructor.getID());
                        course.addLecture(slide, curr_instructor);
                    }

                    else if(n == 2)
                    {
                        System.out.print("Enter topic of video: ");
                        String topic = br.readLine();
                        System.out.print("Enter filename of video: ");
                        String filename = sc.next();
                        String []split_filename = filename.split("[.]", 0);
                        while(true)
                        {
                            if(split_filename[1].equals("mp4"))
                                break;
                            else
                            {
                                System.out.println("Enter a filename with .mp4 extension: ");
                                filename = sc.next();
                                split_filename = filename.split("[.]", 0);
                            }
                        }
                        Video video = new Video(topic, filename, curr_instructor.getID());
                        course.addLecture(video, curr_instructor);
                    }

                    break;

                case "2":
                    System.out.println("1. Add Assignment\n" +
                            "2. Add Quiz");
                    n = sc.nextInt();

                    if(n==1)
                    {
                        System.out.print("Enter problem statement: ");
                        String prob_statement = br.readLine();
                        System.out.println("Enter max marks: ");
                        int max_marks = sc.nextInt();
                        Assignment assignment = new Assignment(prob_statement, max_marks);
                        course.addAssessment(curr_instructor, assignment);
                    }
                    else if(n==2)
                    {
                        System.out.println("Enter quiz question: ");
                        String question = br.readLine();
                        Quiz quiz = new Quiz(question);
                        course.addAssessment(curr_instructor, quiz);
                    }
                    break;

                case "3":
                    course.showLectures(curr_instructor);
                    break;

                case "4":
                    if(!course.showAssessments(curr_instructor, 0))
                        System.out.println("No Assignments");
                    break;

                case "5":
                    if(!course.showAssessments(curr_instructor, 1))
                    {
                        System.out.println("No Assignments to grade");
                    }
                    else
                    {
                        System.out.print("Enter ID of assessment to view submissions: ");
                        int idx = sc.nextInt();
                        Assessment assessment = course.getAssessments().get(idx);
                        System.out.println("Choose ID from these ungraded submissions");
                        if(!course.showStudents_with_Assessment(assessment))
                        {
                            System.out.println("No students have submitted this assignment");
                        }
                        else
                        {
                            int stu_idx = sc.nextInt();
                            Student student = course.getStudents().get(stu_idx);
                            Submission submission = student.getMap().get(assessment);
                            System.out.print("Submission: ");
                            System.out.println(submission.getStu_ans());
                            System.out.println("-------------------------------");
                            System.out.print("Max Marks: ");
                            System.out.println(assessment.getMaxMarks());
                            System.out.print("Marks scored: ");
                            int marks = sc.nextInt();
                            while(true)
                            {
                                if(marks <= assessment.getMaxMarks() && marks>=0)
                                    break;
                                else
                                {
                                    System.out.println("Enter valid marks within the range: 0 to" + assessment.getMaxMarks());
                                    marks = sc.nextInt();
                                }
                            }
                            course.gradeAssessment(curr_instructor, student, assessment, marks);
                        }
                    }
                    break;

                case "6":
                    System.out.println("List of Open Assessments:");
                    if(!course.showAssessments(curr_instructor, 2))
                    {
                        System.out.println("No assessments are open");
                    }
                    else
                    {
                        System.out.print("Enter id of assignment to close: ");
                        int id = sc.nextInt();
                        Assessment assessment = course.getAssessments().get(id);
                        course.CloseAssessment(curr_instructor, assessment);
                    }
                    break;

                case "7":
                    course.showComments(curr_instructor);
                    break;

                case "8":
                    System.out.print("Enter comment: ");
                    String comment = br.readLine();
                    Comments comment_content = new Comments(comment, curr_instructor.getID());
                    course.addComment(curr_instructor, comment_content);
                    break;

                default:
                    System.out.println("Wrong Input. Please Try Again");
                    break;
            }
            System.out.println("Welcome " + curr_instructor.getID());
            curr_instructor.showMenu();
            input = br.readLine();
        }

    }
    public static void student(Course course, Scanner sc) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Students:");
        LinkedList<Student> students = course.getStudents();
        for(int i=0; i<students.size(); i++)
        {
            System.out.println(i + " - " + students.get(i).getID());
        }
        System.out.print("Choose id: ");
        int ID = sc.nextInt();
        Student curr_student = students.get(ID);
        System.out.println("Welcome " + curr_student.getID());
        curr_student.showMenu();
        String input = sc.next();
        while(!input.equals("7"))
        {
            switch (input)
            {
                case "1":
                    course.showLectures(curr_student);
                    break;

                case "2":
                    if(!course.showAssessments(curr_student, 0))
                        System.out.println("Hurray! No Assignments");
                    break;

                case "3":
                    System.out.println("Pending Assignments");
                    if(!course.showAssessments(curr_student, 3))
                    {
                        System.out.println("No pending assessments");
                    }
                    else
                    {
                        System.out.print("Enter ID of assessment: ");
                        int idx = sc.nextInt();
                        Assessment assessment = course.getAssessments().get(idx);
                        if(assessment instanceof Assignment)
                        {
                            System.out.print("Enter filename of assignment: ");
                            String filename = sc.next();
                            String []split_filename = filename.split("[.]", 0);
                            while(true)
                            {
                                if(split_filename[1].equals("zip"))
                                    break;
                                else
                                {
                                    System.out.println("Enter a filename with .zip extension: ");
                                    filename = sc.next();
                                    split_filename = filename.split("[.]", 0);
                                }
                            }
                            Submission submission = new Submission(filename);
                            course.submitAssessment(curr_student, assessment, submission);
                        }
                        else
                        {
                            System.out.print(assessment.getProblem_Question() + " ");
                            String answer = br.readLine();
                            Submission submission = new Submission(answer);
                            course.submitAssessment(curr_student, assessment, submission);
                        }
                    }
                    break;

                case "4":
                    course.viewGrades(curr_student);
                    break;

                case "5":
                    course.showComments(curr_student);
                    break;

                case "6":
                    System.out.print("Enter comment: ");
                    String comment_content = br.readLine();
                    Comments comment = new Comments(comment_content, curr_student.getID());
                    course.addComment(curr_student, comment);
                    break;

                default:
                    System.out.println("Wrong Input. Please Try Again");
                    break;
            }
            System.out.println("Welcome " + curr_student.getID());
            curr_student.showMenu();
            input = sc.next();
        }
    }
    public static void showMenu()
    {
        System.out.println("""
                Welcome to Backpack
                1. Enter as instructor
                2. Enter as student
                3. Exit""");
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        showMenu();
        String input = br.readLine();
        Course course = new Course();
        course.Initialise();
        while(!input.equals("3"))
        {
            switch (input)
            {
                case "1":
                    instructor(course, sc);
                    break;
                case "2":
                    student(course, sc);
                    break;
                default:
                    System.out.println("Wrong Input. Please Try Again");
            }
            showMenu();
            input = sc.next();
        }
        sc.close();
    }
}
