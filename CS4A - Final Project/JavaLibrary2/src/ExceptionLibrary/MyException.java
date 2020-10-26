
package ExceptionLibrary;

/**
 * This class used to handle exception for string, integer, and float type of value 
 * 
 */
public class MyException 
{
    protected static final String NO_VALUE = "<Undefined>";

    protected void checkStringValue(String valueString, String attributeName) throws Exception
    {
        if (valueString == null || valueString.trim().equals("")) 
        {
            throw new Exception( attributeName + " must have value.");
        }
    }
    
    protected void checkIntegerValue(int intValue, String attributeName) throws Exception 
    {
        if (intValue < 0) 
        {
            throw new Exception( attributeName + " must be >= 0");
        }
    }
    
    protected void checkFloatValue(float floatValue, String attributeName) throws Exception
    {
        if (floatValue < 0.0)
        {
            throw new Exception( attributeName + " must be >= 0");
        }
    }
}
