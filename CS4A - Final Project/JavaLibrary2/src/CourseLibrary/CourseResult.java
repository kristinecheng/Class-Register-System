/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseLibrary;

import CourseScheduler.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * This class interact with the CourseSchedule to get the final information of 
 * each courses. 
 * It will output the result into a new text file 
 */
public class CourseResult 
{
    private PrintWriter output;
    private ArrayList<Course> courses;
    private CourseSchedule schedule;
    
    public CourseResult(String fileName, ArrayList<Course> courses, CourseSchedule schedule) throws Exception
    {
        setOutput(fileName);
        setCourses(courses);
        setSchedule(schedule);
    }
    
    public void setOutput(PrintWriter output) 
    {
        this.output = output;
    }

    public void setOutput(String pathname) throws FileNotFoundException 
    {
        this.output = new PrintWriter(new File(pathname));
    }

    public ArrayList<Course> getCourses() 
    {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) 
    {
        this.courses = courses;
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
     * Display Scheduled Courses
     */
    public void printScheduledCourses() 
    {
        for (Course course : courses) 
        {
            if (schedule.ScheduledSession(course))  
            {
                // output.println(course);
                // output.println();

                for (Sessions session : schedule.getScheduledCourses(course)) 
                {
                    output.println(session);
                    output.println();
                }
                 output.flush();
            }
            output.println();
        }
        output.flush();
    }

    /**
     * Display Unscheduled Courses
     */
    public void printUnscheduledCourses() 
    {
        for (Course course : courses) 
        {
            if (!schedule.ScheduledSession(course)) 
            {
                output.println(course.getCourse_id() + "\nMin Students: " + course.getMin_student());
                output.println();
                output.println();
            }
        }
        output.flush();
    }
    
    /**
     * Get the total courses 
     * @return total course 
     */
    public int getNumCourses() 
    {
        return courses.size();
    }
    
    /**
     * Get the scheduled session
     * @return total amount of scheduled sessions
     */
    public int getScheduledSessions()
    {
        int count = 0;
        
        for (Course course : courses) 
        {
            if (schedule.ScheduledSession(course))  
            {
                for (Sessions session : schedule.getScheduledCourses(course)) 
                {
                    count++;
                }
            }
        }
       return count;
    }
    
    /**
     * Get the scheduled courses
     * @return total amount of scheduled courses
     */
    public int getScheduledCourses()
    {
        int count = 0;
        
        for (Course c : courses)
        {
            if (schedule.ScheduledSession(c))
            {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Get the Unscheduled courses
     * @return total amount of unscheduled courses
     */
    public int getUnscheduledCourses()
    {
        int count = 0;
        
        for (Course c : courses)
        {
            if (!schedule.ScheduledSession(c))
            {
                count++;
            }
        }
        
        return count;
    }
}
