
package PersonalInformation;

import ExceptionLibrary.MyException;


public class SchoolMembers extends MyException implements Comparable
{
    private String first_name;
    private String last_name;
    private String email;
    private String telephone;
    private Address address;
    private String personal_id;
    private int coursesCount;
    
    /**
     * Constructor for making SchoolMembers object that contains common personal information and address 
     * @param first_name This present the first name 
     * @param last_name This present the last name
     * @param email This present the email address
     * @param telephone This present the telephone number
     * @param street This present the street address 
     * @param city This present the city of address
     * @param state This present the state of address
     * @param zip_code This present the zip code
     * @param personal_id This present the UNIQUE personal id 
     * @throws Exception 
     */
    public SchoolMembers(String first_name, String last_name, String email, String telephone, String street,
            String city, String state, String zip_code, String personal_id) throws Exception
    {
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setTelephone(telephone);
        setAddress(street, city, state, zip_code);
        setPersonal_id(personal_id);
    }
    
    /**
     * Constructor that contains common personal information 
     * @param first_name This present the first name 
     * @param last_name This present the last name
     * @param email This present the email address
     * @param telephone This present the telephone number
     * @param personal_id This present the UNIQUE personal id 
     * @throws Exception 
     */
    public SchoolMembers(String first_name, String last_name, String email, String telephone, String personal_id) throws Exception
    {
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setTelephone(telephone);
        setPersonal_id(personal_id);
    }
    
    /*
     * Constructor with no args 
    */
    public SchoolMembers() throws Exception 
    {
        setFirst_name(NO_VALUE);
        setLast_name(NO_VALUE);
        setEmail(NO_VALUE);
        setTelephone(NO_VALUE);
        setAddress(NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE);
        setPersonal_id(NO_VALUE);
    }

    /**
     * Function return first name value 
     * @return the first_name
     */
    public String getFirst_name() 
    {
        return first_name;
    }

    /**
     * Function to set value for first name 
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) throws Exception
    {
        checkStringValue(first_name, "First Name");
        this.first_name = first_name;
    }

    /**
     * Function return last name value 
     * @return the last_name
     */
    public String getLast_name() 
    {
        return last_name;
    }

    /**
     * Function to set last name value 
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) throws Exception
    {
        checkStringValue(last_name, "Last Name");
        this.last_name = last_name;
    }

    /**
     * Function to get email value 
     * @return the email
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * Function to set value of eamil 
     * @param email the email to set
     */
    public void setEmail(String email) throws Exception
    {
        checkStringValue(email, "Email");
        this.email = email;
    }

    /**
     * Function get telephone value 
     * @return the telephone
     */
    public String getTelephone() 
    {
        return telephone;
    }

    /**
     * Function to set value for telephone number 
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) throws Exception
    {
        checkStringValue(telephone, "Telephone");
        this.telephone = telephone;
    }

    /**
     * Function return address value 
     * @return the address
     */
    public Address getAddress() 
    {
        return address;
    }

    /**
     * Function set value fro address 
     * @param address the address to set
     */
    public void setAddress(String street, String city, String state, String zip_code) throws Exception
    {
        this.address = new Address(street, city, state, zip_code);
    }

    /**
     * Function return personal unique id 
     * @return the personal_id
     */
    public String getPersonal_id() 
    {
        return personal_id;
    }

    /**
     * Function to set value for personal id 
     * @param personal_id the personal_id to set
     */
    public void setPersonal_id(String personal_id) throws Exception
    {
        checkStringValue(personal_id, "Personal Id");
        this.personal_id = personal_id;
    }
   
    /**
     * Function increment course count 
     */
    public void addCourse() 
    {
        coursesCount++;
    }

    /**
     * Function return amount of courses
     * @return integer 
     */
    public int getNumCourses() 
    {
        return coursesCount;
    }
    
    /**
     * Function to check personal id 
     * @param o Present object 
     * @return boolean 
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        SchoolMembers member = (SchoolMembers) o;
        return personal_id == member.personal_id;
    }
    
    @Override
    public int hashCode()
    {
        return personal_id.hashCode();
    }
    
    /**
     * COmpare two object 
     * @param o 
     * @return 0 or 1
     */
    @Override 
    public int compareTo(Object o)
    {
        SchoolMembers member = (SchoolMembers) o;
        
        String my_full_name = member.first_name + member.last_name;
        String full_name = this.first_name + this.last_name;
        
        return full_name.compareTo(my_full_name);
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Name: ");
        builder.append(first_name);
        builder.append(" ");
        builder.append(last_name);
        builder.append("\nEmail: ");
        builder.append(email);
        builder.append("\nTelephone: ");
        builder.append(telephone);
        builder.append("\nAddress: ");
        builder.append(address.toString());
        builder.append("\nPersonal ID: ");
        builder.append(personal_id);
        
        return builder.toString();
    }
}
