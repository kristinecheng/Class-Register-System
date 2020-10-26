
package PersonalInformation;

import ExceptionLibrary.MyException;

/**
 * This class contains all the information of address 
 */
public class Address extends MyException
{
    private String street;
    private String city;
    private String state;
    private String zip_code;
    
    /**
     * Constructor to set up all the value 
     * @param street
     * @param city
     * @param state
     * @param zip_code
     * @throws Exception 
     */
    public Address(String street, String city, String state, String zip_code) throws Exception
    {
        setStreet(street);
        setCity(city);
        setState(state);
        setZip_code(zip_code);
    }
    
    public Address() throws Exception
    {
        this(NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE);
    }
    
    /**
     * @return the street
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) throws Exception 
    {
        checkStringValue(street, "Street");
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() 
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) throws Exception
    {
        checkStringValue(city, "City");
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() 
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) throws Exception 
    {
        checkStringValue(state, "State");
        this.state = state;
    }

    /**
     * @return the zip_code
     */
    public String getZip_code() 
    {
        return zip_code;
    }

    /**
     * @param zip_code the zip_code to set
     */
    public void setZip_code(String zip_code) throws Exception
    {
        checkStringValue(zip_code, "Zip Code");
        this.zip_code = zip_code;
    }
  
    @Override
    public String toString()
    {
        return street + ", " + city + ", " + state + " " + zip_code;
    }
}
