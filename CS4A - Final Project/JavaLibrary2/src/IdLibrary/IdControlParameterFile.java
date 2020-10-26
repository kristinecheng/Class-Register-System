/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class reads into a text file that contains the parameter for
 * generating random id
 * It contains the minimum start value, and maximum value 
 */
public class IdControlParameterFile 
{
    /**
     * Reads into text file to get needed data
     * @return Random type of id 
     * @throws Exception 
     */
    public static RandomId readParameterInfo() throws Exception
    {
        RandomId id = new RandomId();    
        
        try
        {
            Scanner input = new Scanner(new File("src/IdControlParameter.txt"));
            
            int min = input.nextInt();
            int max = input.nextInt();
            
            if (min > max)
            {
                System.out.println("ID range error, please check the file");
            }
            
            id.setMin(min);
            id.setMax(max);
            
        }
         catch (FileNotFoundException ex)
        {
            throw new FileNotFoundException("File Path not found");
        }
        catch (InputMismatchException ex)
        {
            throw new InputMismatchException("Data Error, Please Check Input File");
        }
        
        return id;
    }
}
