
package CourseLibrary;

import ExceptionLibrary.MyException;

/**
 * This class contains all the base information of a course
 */
public class Course extends MyException
{
    private String department;
    private String course_code;
    private String description;
    private int min_student;
    private int max_student;
    
    /**
     * Constructor to set up all the needed information 
     * @param department 
     * @param course_code
     * @param description
     * @param min_student
     * @param max_student
     * @throws Exception 
     */
    public Course(String department, String course_code, String description, int min_student, int max_student) throws Exception
    {
        setDepartment(department);
        setCourse_code(course_code);
        setDescription(description);
        setMin_student(min_student);
        setMax_student(max_student);
    }
    
    public Course() throws Exception
    {
        setDepartment(NO_VALUE);
        setCourse_code(NO_VALUE);
        setDescription(NO_VALUE);
        setMin_student(0);
        setMax_student(0);
    }

    /**
     * @return the department
     */
    public String getDepartment() 
    {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) throws Exception
    {
        checkStringValue(department, "Department");
        this.department = department;
    }

    /**
     * @return the course_code
     */
    public String getCourse_code() 
    {
        return course_code;
    }

    /**
     * @param course_code the course_code to set
     */
    public void setCourse_code(String course_code) throws Exception
    {
        checkStringValue(course_code, "Course Code");
        this.course_code = course_code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) throws Exception
    {
        checkStringValue(description, "Description");
        this.description = description;
    }

    /**
     * @return the min_student
     */
    public int getMin_student() 
    {
        return min_student;
    }

    /**
     * @param min_student the min_student to set
     */
    public void setMin_student(int min_student) throws Exception
    {
        checkIntegerValue(min_student, "Minimum Student");
        this.min_student = min_student;
    }

    /**
     * @return the max_student
     */
    public int getMax_student() 
    {
        return max_student;
    }

    /**
     * @param max_student the max_student to set
     */
    public void setMax_student(int max_student) throws Exception
    {
        checkIntegerValue(max_student, "Maximum Student");
        this.max_student = max_student;
    }
  
    public String getCourse_id()
    {
        return department + course_code;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        Course course = (Course) o;
        
        return getCourse_code().equals(course.getCourse_code());
    }
   
    @Override
    public int hashCode()
    {
        return getCourse_id().hashCode();
    }
    
    @Override 
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append(getCourse_id());
        builder.append(": ");
        builder.append(description);
        builder.append(" ");
        
        return builder.toString();
    }
}
