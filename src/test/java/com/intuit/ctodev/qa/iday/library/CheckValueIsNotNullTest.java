package com.intuit.ctodev.qa.iday.library;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckValueIsNotNullTest
{

    @Test(description="check value not null", groups = { "dptest", "testnull"}, dataProvider = "testDP")
    public void testValueIsNotNull(String value)
    {               
        System.out.println("Start - sample test");
        assertTrue(value != null, "value is null.");
        System.out.println("End - sample test");        
    }
    
    @DataProvider(name = "testDP")
    public Object[][] testDP()
    {
        return new Object[][]
        {
                { "test1"}, //regular string
                { " test2 "}, //string trailing spaces
                { null }, //null
                { " "}, //empty string with space
                { ""}, //empty string
        };
    } 
}
