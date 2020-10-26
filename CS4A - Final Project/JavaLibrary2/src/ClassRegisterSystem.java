/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import CourseLibrary.*;
import FacultyLibrary.*;
import IdLibrary.*;
import StudentLibrary.*;
import AlgorithmsLibrary.*;
import CourseScheduler.*;
/**
 * This program reads in the input file for registration and scheduling sessions
 * to students, faculty, and courses.
 * @author krist
 */
public class ClassRegisterSystem 
{
    public static void main(String [] arg)
    {
        try
        {
            // Reads input file of student info, faculty info, and course info
            ArrayList<Student> studentInfoFile = StudentFile.readStudentsInfo();
            ArrayList<Faculty> facultyInfoFile = FacultyFile.readFacultyInfo();
            ArrayList<Course> courseInfoFile = CourseSessionFile.readCourseInfo();
           
            // Generate unique Id for sessions by reading into id parameter file
            RandomId sessionId = IdControlParameterFile.readParameterInfo();
            
            // Generate algorithm for scheduler by reading into algorithm parameter file
            ScheduleAlgorithms scheduler = ScheduleParameter.readScheduleParameter();
            
            DefaultAlgorithm plan = new DefaultAlgorithm();
            // Plan the Schedule using default algorithm
            CourseSchedule result = plan.defaultSchedule(studentInfoFile, facultyInfoFile, courseInfoFile, scheduler, sessionId);
            
            // Display Schedueled.txt
            CourseResult cPrinter = new CourseResult("ScheduledCourseSessions.txt", courseInfoFile, result);
            cPrinter.printScheduledCourses();
            
            // Display Unscheduled.txt
            cPrinter.setOutput("UnscheduledCourseSessions.txt");
            cPrinter.printUnscheduledCourses();
            
            // Display Faculty.txt
            FacultyResult fPrinter = new FacultyResult("Faculty.txt", facultyInfoFile, result);
            fPrinter.printFaculty();
            
            // Dispaly ScheduledStudents.txt
            StudentResult sPrinter = new StudentResult("ScheduledStudents.txt", studentInfoFile, result);
            sPrinter.printScheduledStudents();
            
            // Display UnscheduledStudents.txt
            sPrinter.setOutput("UnscheduledStudents.txt");
            sPrinter.printUnscheduledStudents();
            
            // Dispaly statement into consol
            printConsol(sPrinter.getTotalStudents(), fPrinter.getNumFaculty(), cPrinter.getNumCourses()
            , cPrinter.getScheduledSessions(), cPrinter.getUnscheduledCourses(), sPrinter.getNumUnscheduledStudents());
         
        }
       catch(FileNotFoundException ex) 
       {
            System.out.println(ex.getMessage());
       }
       catch(InputMismatchException ex) 
       {
            System.out.println("File " + ex.getMessage() +  " contains invalid format.");
       }
        catch(Exception ex) 
        {
            System.out.println("Exception occured: " + ex);
        }
    }
    
    public static void printConsol(int amtStudent, int amtFaculty, int amtCourses, int amtSessions, int amtUnscheCourses, int amtUnscheStudent)
    {
        System.out.println("Total Students: " + amtStudent);
        System.out.println("Total Faculty: " + amtFaculty);
        System.out.println("Total Courses: " + amtCourses);
        System.out.println("Total Scheduled Sessions: "+ amtSessions);
        System.out.println("Total Unscheduled Courses: " + amtUnscheCourses);
        System.out.println("Total Unscheduled Students: " + amtUnscheStudent);
    }
}
