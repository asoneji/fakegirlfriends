package com.intuit.ctodev.qa.iday.library;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNameTest
{
    CreateName myName = null;
    
    @BeforeMethod
    public void CreateNameClass()
    {
        myName = new CreateName();
    }

    @Test(description="check the name is correct", dataProvider = "testDP", groups = { "demo"})
    public void checkName(String fName, String lName)
    {
        myName.setName(fName, lName);
        
        Assert.assertEquals(myName.getName(), fName + " " + lName, "Full name is not as expected.");
    }
    
    @DataProvider(name = "testDP")
    public Object[][] testDP()
    {
        return new Object[][]
        {
                { "Bruce", "Wayne"},
                { "James", "Gordon"},
        };
    } 
}
