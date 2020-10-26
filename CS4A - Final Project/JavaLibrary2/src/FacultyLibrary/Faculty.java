
package FacultyLibrary;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import PersonalInformation.SchoolMembers;

/**
 * This class contains all the information of a faculty 
 * 
 */
public class Faculty extends SchoolMembers
{
    private Date hired_date;
    private boolean tenured;
    private ArrayList<String> course_taught;

    /**
     * Constructor to set up all the value 
     * @param first_name
     * @param last_name
     * @param email
     * @param telephone
     * @param street
     * @param city
     * @param state
     * @param zip_code
     * @param personal_id
     * @param hired_date
     * @param tenured
     * @param course_taught
     * @throws Exception 
     */
    public Faculty(String first_name, String last_name, String email, String telephone, String street, String city, String state, String zip_code, 
            String personal_id, Date hired_date, boolean tenured, ArrayList<String> course_taught) throws Exception
    {
        super(first_name, last_name, email, telephone, street, city, state, zip_code, personal_id);
        setHired_date(hired_date);
        setTenured(tenured);
        setCourse_taught(course_taught);
    }
    
    public Faculty() throws Exception
    {
        super();
        hired_date = new Date();
        tenured = false;
        course_taught = new ArrayList<>();
    }
    /**
     * @return the hired_date
     */
    public Date getHired_date() 
    {
        return hired_date;
    }

    /**
     * @param hired_date the hired_date to set
     */
    public void setHired_date(Date hired_date)
    {
        this.hired_date = hired_date;
    }

    /**
     * @return the tenured
     */
    public boolean isTenured() 
    {
        return tenured;
    }

    /**
     * @param tenured the tenured to set
     */
    public void setTenured(boolean tenured) 
    {
        this.tenured = tenured;
    }

    /**
     * @return the course_taught
     */
    public ArrayList<String> getCourse_taught() 
    {
        return course_taught;
    }

    /**
     * @param course_taught the course_taught to set
     */
    public void setCourse_taught(ArrayList<String> course_taught) 
    {
        this.course_taught = course_taught;
    }
  
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
        
        builder.append(super.toString());
        builder.append("Date Hired: ");
        builder.append(date_format.format(hired_date));
        if (tenured == true)
        {
            builder.append("\nTnured");
        }
        else
        {
            builder.append("\nNot Tnured");
        }
        
        return builder.toString();
    }
    
}
