
package StudentLibrary;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import PersonalInformation.SchoolMembers;

/**
 * This class contains all the information of student 
 */
public class Student extends SchoolMembers
{
    private Date birth_date;
    private float gpa;
    private Date attend_date;
    private ArrayList<String> course_taken;
    
    /**
     * Constructor to set up all the values 
     * @param first_name
     * @param last_name
     * @param email
     * @param telephone
     * @param street
     * @param city
     * @param state
     * @param zip_code
     * @param personal_id
     * @param birth_date
     * @param gpa
     * @param attend_date
     * @param course_taken
     * @throws Exception 
     */
    public Student(String first_name, String last_name, String email, String telephone, String street, String city, String state, String zip_code, 
            String personal_id, Date birth_date, float gpa, Date attend_date, ArrayList<String> course_taken) throws Exception
    {
        super(first_name, last_name, email, telephone, street, city, state, zip_code, personal_id);
        setBirth_date(birth_date);
        setGpa(gpa);
        setAttend_date(attend_date);
        setCourse_taken(course_taken);
    }
    
    public Student() throws Exception
    {
        super();
        setBirth_date(birth_date);
        setGpa(0);
        setAttend_date(attend_date);
    }
    /**
     * @return the birth_date
     */
    public Date getBirth_date() 
    {
        return birth_date;
    }

    /**
     * @param birth_date the birth_date to set
     */
    public void setBirth_date(Date birth_date) 
    {
        this.birth_date = birth_date;
    }

    /**
     * @return the gpa
     */
    public float getGpa() 
    {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(float gpa) throws Exception
    {
        checkFloatValue(gpa, "GPA");
        this.gpa = gpa;
    }

    /**
     * @return the attend_date
     */
    public Date getAttend_date() 
    {
        return attend_date;
    }

    /**
     * @param attend_date the attend_date to set
     */
    public void setAttend_date(Date attend_date) 
    {
        this.attend_date = attend_date;
    }

    /**
     * @return the course_taken
     */
    public ArrayList<String> getCourse_taken() 
    {
        return course_taken;
    }

    /**
     * @param course_taken the course_taken to set
     */
    public void setCourse_taken(ArrayList<String> course_taken) 
    {
        this.course_taken = course_taken;
    }
 
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
        
        builder.append(super.toString());
        builder.append("\nBirth Date: ");
        builder.append(date_format.format(birth_date));
        builder.append("\nCurrent GPA: ");
        builder.append(gpa);
        builder.append("\nDate Enrolled: ");
        builder.append(date_format.format(attend_date));
        
        return builder.toString();
    }
    
    
}
