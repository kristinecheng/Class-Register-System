
package IdLibrary;

import java.util.ArrayList;
import java.util.Random;
import ExceptionLibrary.MyException;

/**
 * This class contains all the information of generating an id 
 * 
 */
public class RandomId extends MyException implements IdGenerator
{
    private ArrayList<String> usedIds = new ArrayList<String>();
    private int min; 
    private int max;
    
    /**
     * Constructor to set up the value 
     * @param min
     * @param max
     * @throws Exception 
     */
    public RandomId(int min, int max) throws Exception
    {
        setMin(min);
        setMax(max);
    }
    
    public RandomId() throws Exception
    {
        setMin(0);
        setMax(0);
    }
    /**
     * @return the usedIds
     */
    public ArrayList<String> getUsedIds() 
    {
        return usedIds;
    }

    /**
     * @param usedIds the usedIds to set
     */
    public void setUsedIds(ArrayList<String> usedIds) 
    {
        this.usedIds = usedIds;
    }
    
    /**
     * @return the min
     */
    public int getMin() 
    {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) throws Exception
    {
        checkIntegerValue(min, "Minimum Id");
        this.min = min;
    }

    /**
     * @return the max
     */
    public int getMax() 
    {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) throws Exception
    {
        checkIntegerValue(max, "Maximum Id");
        this.max = max;
    }

    /**
     * Generate random id for each session and personal id 
     * @return String type of value 
     */
    public String generateID()
    {
        Random rand = new Random();
        
        int randomId = rand.nextInt(max) + min;
        
        while(usedIds.contains(Integer.toBinaryString(randomId)))
        {
            randomId = rand.nextInt(max) + min;
        }
        
        usedIds.add(Integer.toBinaryString(randomId));
        return Integer.toString(randomId);
        
    }
    
    @Override 
    public String displayID()
    {
        return generateID();
    }
    
}
