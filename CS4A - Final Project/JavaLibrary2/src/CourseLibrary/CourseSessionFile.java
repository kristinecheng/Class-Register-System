
package CourseLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class reads into the course input text file to get the basic 
 * information for each courses. 
 */
public class CourseSessionFile 
{
    /**
     * Reads into text file to get needed data 
     * @return Course type of ArrayList 
     * @throws Exception 
     */
    public static ArrayList<Course> readCourseInfo()throws Exception
    {
        
        ArrayList<Course> courseInfo = new ArrayList<Course>();
        
        try
        {
            Scanner input = new Scanner(new File("src/CourseInfo.txt"));
          
            while(input.hasNext())
            {
               
                int minStudents = input.nextInt();
                int maxStudents = input.nextInt();
                String department = input.next();
                String code = input.next();
                String descirption = input.nextLine();
                // String newline = input.nextLine();
                
                if (minStudents > maxStudents)
                {
                    System.out.println("Error input for student min and max amount, please check file");
                }
                
                Course course = new Course();
                course.setMin_student(minStudents);
                course.setMax_student(maxStudents);
                course.setDepartment(department);
                course.setCourse_code(code);
                course.setDescription(descirption);
                
                courseInfo.add(course);
                
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
        
        return courseInfo;
    }
}
