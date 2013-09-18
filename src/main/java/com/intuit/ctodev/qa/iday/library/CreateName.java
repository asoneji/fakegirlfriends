package com.intuit.ctodev.qa.iday.library;

public class CreateName
{
    public String fullName = null;
    
    public void setName(String firstName, String lastName)
    {
        try 
        {
            fullName = firstName + " " + lastName;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String getName()
    {
        return fullName;
    }
}
