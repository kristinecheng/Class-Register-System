/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentLibrary;

import CourseScheduler.*;
import CourseLibrary.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *This class interact with the CourseSchedule to get the final information of 
 * each student. 
 * It will output the result into a new text file, named by user input 
 * 
 */
public class StudentResult 
{
    private PrintWriter output;
    private ArrayList<Student> students;
    private CourseSchedule schedule;
    
    public StudentResult(String fileName, ArrayList<Student> students, CourseSchedule schedule) throws Exception
    {
        setOutput(fileName);
        setStudents(students);
        setSchedule(schedule);
        
    }
    
    public PrintWriter getOutput() 
    {
        return output;
    }

    public void setOutput(PrintWriter output) 
    {
        this.output = output;
    }

    public void setOutput(String pathname) throws FileNotFoundException 
    {
        this.output = new PrintWriter(new File(pathname));
    }

    public ArrayList<Student> getStudents() 
    {
        return students;
    }

    public void setStudents(ArrayList<Student> students) 
    {
        this.students = students;
    }

    public CourseSchedule getSchedule() 
    {
        return schedule;
    }

    public void setSchedule(CourseSchedule schedule) 
    {
        this.schedule = schedule;
    }
    
    /**
     * Display all Scheduled Students
     */
    public void printScheduledStudents() 
    {
        for (Student student : students) 
        {
            if (schedule.getStudentScheduel(student).size() > 0) 
            {
                output.println(student);
                output.println();

                for (Sessions session : schedule.getStudentScheduel(student)) 
                {
                    output.println("Session ID: " + session.getSession_id()
                            + " Course ID: " + session.getCourse().getCourse_id()
                            + "\n" + session.getCourse().getDescription());
                    output.println();
                }
                output.println("-----");
                output.println();
            }
        }
        
        output.flush();
    }
    
    /**
     *  Display all Unscheduled students
     */
    public void printUnscheduledStudents() 
    {
        for (Student student : students) 
        {
            if (schedule.getStudentScheduel(student).size() == 0) 
            {
                output.println(student);
                output.println("-----");
                output.println();
            }
        }

        output.flush();
    }

    /**
     * Get scheduled student
     * @return total amount of scheduled student
     */
    public int getNumScheduledStudents() 
    {
        int count = 0;

        for (Student s : students) 
        {
           if (schedule.getStudentScheduel(s).size() > 0) 
           {
               count++;
           }
        }

        return count;
    }
    
    /**
     * Get Unscheduled student
     * @return total amount of unscheduled student 
     */
    public int getNumUnscheduledStudents() 
    {
        int count = 0;

        for (Student s : students) 
        {
           if (schedule.getStudentScheduel(s).size() == 0) 
           {
               count++;
           }
        }

        return count;
    }
    
    /**
     * Get all students
     * @return total amount of student 
     */
    public int getTotalStudents()
    {
        return getNumScheduledStudents() + getNumUnscheduledStudents();
    }
}
