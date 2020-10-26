
package FacultyLibrary;

import CourseScheduler.*;
import CourseLibrary.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class interact with the CourseSchedule to get the final information of 
 * each faculty. 
 * It will output the result into a new text file, named by user input 
 * 
 */
public class FacultyResult 
{
    private PrintWriter output;
    private ArrayList<Faculty> faculty;
    private CourseSchedule schedule;
    
    public FacultyResult(String fileName, ArrayList<Faculty> faculty, CourseSchedule schedule) throws FileNotFoundException 
    {
        setOutput(fileName);
        setFaculty(faculty);
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

    public ArrayList<Faculty> getFaculty() 
    {
        return faculty;
    }

    public void setFaculty(ArrayList<Faculty> faculty) 
    {
        this.faculty = faculty;
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
     * Print Faculties information into out[ut text file 
     */
     public void printFaculty() 
     {
        for (Faculty f : faculty) 
        {
            output.println(f);
            output.println();

            for (Sessions session : schedule.getFacultyScheduel(f)) 
            {
                output.println(session);
                output.println();
            }

            output.println("-----");
            output.println();
        }
        output.flush();
    }

     /**
      * Get the total amount of faculty
      * @return total amount of faculty 
      */
    public int getNumFaculty() 
    {
        int count = 0;
        for(Faculty f : faculty)
        {
            count++;
        }
        
        return count;
    }
}
