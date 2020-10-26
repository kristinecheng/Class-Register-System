
package CourseScheduler;

import java.util.ArrayList;
import CourseLibrary.*;
import FacultyLibrary.*;
import StudentLibrary.*;

/**
 * This class generate out the session list for students, faculties, and courses.
 * 
 */
public class CourseSchedule 
{
    private ArrayList<Sessions> sessionsList;
    
    public CourseSchedule(ArrayList<Sessions> sessionsList)
    {
         this.sessionsList = sessionsList;
    }
    
    public CourseSchedule()
    {
        sessionsList = new ArrayList<Sessions>();
    }
    
    public ArrayList<Sessions> getSessionsList()
    {
        return sessionsList;
    }
    
    public void setSessionsList(ArrayList<Sessions> sessionsList)
    {
        this.sessionsList = sessionsList;
    }
    
    /**
     * Student Schedule 
     * @param student
     * @return sessions type of ArrayList()
     */
    public ArrayList<Sessions> getStudentScheduel(Student student)
    {
        ArrayList<Sessions> studentScheduel = new ArrayList<Sessions> ();
        
        for(Sessions session : sessionsList)
        {
            for (Student s : session.getStudentsList())
            {
                if (s.equals(student))
                {
                    studentScheduel.add(session);
                    break;
                }
            }
        }
        
        return studentScheduel;
    }
    
    /**
     *  Generate the Faculty Schedule
     * @param instructor
     * @return Sessions type of ArrayList 
     */
    public ArrayList<Sessions> getFacultyScheduel(Faculty instructor)
    {
        ArrayList<Sessions> instructorScheduel = new ArrayList<Sessions>();
        
        for (Sessions s : sessionsList)
        {
           if (s.getInstructor().equals(instructor))
           {
               instructorScheduel.add(s);
           }
        }
        
        return instructorScheduel;
    }
    
    /**
     * Get Scheduled Courses List
     * @param course
     * @return sessions type of ArrayList 
     */
    public ArrayList<Sessions> getScheduledCourses(Course course)
    {
        ArrayList<Sessions> course_sessions = new ArrayList<Sessions>();
        
        for (Sessions s : sessionsList)
        {
            if (course.equals(s.getCourse()) && s.isSchedualed())
            {
                course_sessions.add(s);
            }
        }
        
        return course_sessions;
    }
     
    /**
     * Check if the session of that course is scheduled
     * @param course
     * @return true/false
     */
    public boolean ScheduledSession(Course course)
    {
         for (Sessions s : sessionsList)
        {
            if (s.getCourse().equals(course)&& s.isSchedualed())
            {
                return true;
            }
        }
         
         return false;
    }
}
