
package FacultyLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import IdLibrary.RandomId;

/**
 * This class reads into the faculty input file list that contains
 * all the faculty information 
 *
 */
public class FacultyFile 
{
    private static final int FIRST = 0;
    private static final int LAST = 1;
    private static final int EMAIL = 2;
    private static final int TELEPHONE = 3;
    private static final int STREET = 4;
    private static final int CITY = 5;
    private static final int STATE = 6;
    private static final int ZIPCODE = 7;
    private static final int HIREDATE = 8;
    private static final int TENURED = 9;
    
    /**
     * Reads into text file to get needed data
     * @return Faculty type of ArrayList 
     * @throws Exception 
     */
    public static ArrayList<Faculty> readFacultyInfo() throws Exception 
    {
        RandomId id = new RandomId(1, 50);
        
        ArrayList<Faculty> facultyInfo = new ArrayList<Faculty>();
        
        try
        {
            Scanner input = new Scanner(new File("src/FacultyInfo - 1.txt"));
            while(input.hasNext())
            {
                String line = input.nextLine();
               
                ArrayList<String> information = new ArrayList<String> (Arrays.asList(line.split(", ")));
                
                DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
            
                String first_name = information.get(FIRST);
                String last_name = information.get(LAST);
                String email = information.get(EMAIL);
                String telephone = information.get(TELEPHONE);
                String facultyId = id.generateID();
                Date hired = dateformat.parse(information.get(HIREDATE));
                boolean tenured = Boolean.parseBoolean(information.get(TENURED));
                
                ArrayList<String> coursesTaught = new ArrayList<String>();

                for (int i = TENURED; i < information.size(); i++) 
                {  
                    coursesTaught.add(information.get(i));
                }
                
                Faculty faculty = new Faculty();
                faculty.setFirst_name(first_name);
                faculty.setLast_name(last_name);
                faculty.setEmail(email);
                faculty.setTelephone(telephone);
                faculty.setAddress(information.get(STREET), information.get(CITY), information.get(STATE), information.get(ZIPCODE));
                faculty.setPersonal_id(facultyId);
                faculty.setHired_date(hired);
                faculty.setTenured(tenured);
                faculty.setCourse_taught(coursesTaught);
                
                facultyInfo.add(faculty);
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
        
        return facultyInfo;
        
    }
}
