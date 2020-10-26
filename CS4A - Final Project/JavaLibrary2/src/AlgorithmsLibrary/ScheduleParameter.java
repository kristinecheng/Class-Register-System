/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This class reads into the schedule control parameter to set the limitation
 * for sessions needed
 */
public class ScheduleParameter 
{
    /**
     * Reads in text file to get data needed
     * @return ScheduleAlgorithm type 
     * @throws Exception 
     */
    public static ScheduleAlgorithms readScheduleParameter() throws Exception
    {
        ScheduleAlgorithms scheduler = new ScheduleAlgorithms();
        
        try
        {
            Scanner input = new Scanner(new File("src/ScheduledControlParameter.txt"));
            
            int sessions_per_course = input.nextInt();
            int sessions_per_student = input.nextInt();
            int sessions_per_instructor = input.nextInt();
            
            scheduler = new ScheduleAlgorithms(sessions_per_course, sessions_per_student, sessions_per_instructor);
        }
        catch (FileNotFoundException ex)
        {
            throw new FileNotFoundException("File Path not found");
        }
        catch (InputMismatchException ex)
        {
            throw new InputMismatchException("Data Error, Please Check Input File");
        }
        
        return scheduler;
    }
}
