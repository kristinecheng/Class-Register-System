
package AlgorithmsLibrary;

import ExceptionLibrary.*;


/**
 * This class set up the based of schedule algorithm with the limited amount of
 * sessions can be teach or take, and the maximum session for a course.
 */
public class ScheduleAlgorithms extends MyException
{

    private int session_per_course;
    private int session_per_student;
    private int session_per_instructor;
    
    /**
     * Constructor to set up the limitation 
     * @param session_per_course the maximum amount of session can a course have
     * @param session_per_student the maximum amount of session can a student take
     * @param session_per_instructor the maximum amount of session can a instructor taught
     * @throws Exception 
     */
    public ScheduleAlgorithms(int session_per_course, int session_per_student, int session_per_instructor) throws Exception
    {
        setSession_per_course(session_per_course);
        setSession_per_student(session_per_student);
        setSession_per_instructor(session_per_instructor);
    }
    
    public ScheduleAlgorithms() throws Exception
    {
        setSession_per_course(0);
        setSession_per_student(0);
        setSession_per_instructor(0);
    }
    
    /**
     * @return the session_per_course
     */
    public int getSession_per_course() 
    {
        return session_per_course;
    }

    /**
     * @param session_per_course the session_per_course to set
     */
    public void setSession_per_course(int session_per_course) throws Exception
    {
        checkIntegerValue(session_per_course, "Maximum sessions for course");
        this.session_per_course = session_per_course;
    }

    /**
     * @return the session_per_student
     */
    public int getSession_per_student() 
    {
        return session_per_student;
    }

    /**
     * @param session_per_student the session_per_student to set
     */
    public void setSession_per_student(int session_per_student) throws Exception
    {
        checkIntegerValue(session_per_student, "Maximum courses for student");
        this.session_per_student = session_per_student;
    }

    /**
     * @return the session_per_instructor
     */
    public int getSession_per_instructor() 
    {
        return session_per_instructor;
    }

    /**
     * @param session_per_instructor the session_per_instructor to set
     */
    public void setSession_per_instructor(int session_per_instructor) throws Exception
    {
        checkIntegerValue(session_per_instructor, "Maximum courses for instructor");
        this.session_per_instructor = session_per_instructor;
    }
    
}
