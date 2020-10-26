
package StudentLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import IdLibrary.RandomId;

/**
 * This class reads into input file that contains all the student information 
 */
public class StudentFile 
{
    private static final int FIRST = 0;
    private static final int LAST = 1;
    private static final int EMAIL = 2;
    private static final int TELEPHONE = 3;
    private static final int STREET = 4;
    private static final int CITY = 5;
    private static final int STATE = 6;
    private static final int ZIPCODE = 7;
    private static final int BIRTHDATE = 8;
    private static final int GPA = 9;
    private static final int ENROLLDATE = 10;
    
    /**
     * Reads into the student information text file 
     * @return Student type of ArrayList 
     * @throws Exception 
     */
    public static ArrayList<Student> readStudentsInfo() throws Exception
    {
        RandomId id = new RandomId(1, 150);
        
        ArrayList<Student> studentsInfo = new ArrayList<Student>();
        
        try
        {
            Scanner input = new Scanner(new File("src/studentInfo - 1.txt"));
            
            while(input.hasNext())
            {
                String line = input.nextLine();
                
                ArrayList<String> information = new ArrayList<String> (Arrays.asList(line.split(", ")));
                
                DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
                
                String first_name = information.get(FIRST);
                String last_name = information.get(LAST);
                String email = information.get(EMAIL);
                String telephone = information.get(TELEPHONE);
                // Address address = new Address(information.get(STREET), information.get(CITY), information.get(STATE), information.get(ZIPCODE));
                String studentId = id.displayID();
                Date birthday = dateformat.parse(information.get(BIRTHDATE));
                float gpa = Float.parseFloat(information.get(GPA));
                Date enrolled = dateformat.parse(information.get(ENROLLDATE));

                ArrayList<String> courseWanted = new ArrayList<String>();
                for (int i = ENROLLDATE; i < information.size(); i++)
                {
                    courseWanted.add(information.get(i));
                }
                
                Student student = new Student();
                student.setFirst_name(first_name);
                student.setLast_name(last_name);
                student.setEmail(email);
                student.setTelephone(telephone);
                student.setAddress(information.get(STREET), information.get(CITY), information.get(STATE), information.get(ZIPCODE));
                student.setPersonal_id(studentId);
                student.setBirth_date(birthday);
                student.setGpa(gpa);
                student.setAttend_date(enrolled);
                student.setCourse_taken(courseWanted);
                
                studentsInfo.add(student);
                
            }
        }
        catch (FileNotFoundException ex)
        {
            throw new FileNotFoundException("File Path not found");
        }
        catch (InputMismatchException ex)
        {
            throw new InputMismatchException("Data Error, Please Check Input File");
        }
        
        return studentsInfo;
    }
}
