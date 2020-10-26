
package CourseLibrary;

import ExceptionLibrary.MyException;
import java.util.ArrayList;
import FacultyLibrary.Faculty;
import StudentLibrary.Student;

/**
 * This class contains all the information of a session of a course
 * 
 */
public class Sessions extends MyException
{
    private String session_id;
    private ArrayList<Student> studentsList;
    private Faculty instructor;
    private Course course;
    
    /**
     * Constructor to set up all the value 
     * @param session_id
     * @param studentsList
     * @param instructor
     * @param course
     * @throws Exception 
     */
    public Sessions(String session_id, ArrayList<Student> studentsList, Faculty instructor, Course course) throws Exception
    {
        setSession_id(session_id);
        setStudentsList(studentsList);
        setInstructor(instructor);
        setCourse(course);
    }
    
    public Sessions() throws Exception
    {
        setSession_id(" ");
        studentsList = new ArrayList<Student>();
        instructor = new Faculty();
        course = new Course();
    }
    
    /**
     * @return the session_id
     */
    public String getSession_id() 
    {
        return session_id;
    }

    /**
     * @param session_id the session_id to set
     */
    public void setSession_id(String session_id) throws Exception
    {
        checkStringValue(session_id, "Session id");
        this.session_id = session_id;
    }

    /**
     * @return the studentsList
     */
    public ArrayList<Student> getStudentsList() 
    {
        return studentsList;
    }

    /**
     * @param studentsList the studentsList to set
     */
    public void setStudentsList(ArrayList<Student> studentsList) 
    {
        this.studentsList = studentsList;
    }

    /**
     * @return the instructor
     */
    public Faculty getInstructor() 
    {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(Faculty instructor)
    {
        this.instructor = instructor;
    }

    /**
     * @return the course
     */
    public Course getCourse() 
    {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) 
    {
        this.course = course;
    }
  
    public boolean isSchedualed()
    {
        return studentsList.size() >= course.getMin_student() && instructor.getPersonal_id() != null;
    }
    
    public boolean isFull()
    {
        return studentsList.size() == course.getMax_student();
    }
    
    public void addStudent(Student student)
    {
        if (!isFull())
        {
            studentsList.add(student);
        }
    }
    
    public void removeStudent(Student student)
    {
        studentsList.remove(student);
    }
    
    @Override 
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        
        Sessions session = (Sessions) o;
        return session_id == session.getSession_id();
    }
    
    @Override 
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append(course.toString());
        builder.append("\nInstructor: ");
        builder.append(instructor.getFirst_name());
        builder.append(" ");
        builder.append(instructor.getLast_name());
        builder.append("\nID: #");
        builder.append(instructor.getPersonal_id());
        builder.append("\nStudents: ");
        builder.append(studentsList.size());
        builder.append("\n");
        for (Student s : studentsList)
        {
            builder.append("\n");
            builder.append(s.getFirst_name());
            builder.append(" ");
            builder.append(s.getLast_name());
            builder.append("\nID: #");
            builder.append(s.getPersonal_id());
            builder.append("\n");
        }
        
        return builder.toString();
    }
}
