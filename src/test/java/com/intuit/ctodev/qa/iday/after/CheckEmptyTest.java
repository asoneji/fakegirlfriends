package com.intuit.ctodev.qa.iday.after;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmptyTest
{

    @Test(description="check value is empty", groups = { "testempty", "afterfix"}, dataProvider = "testDP")
    public void testValueIsEmpty(String value)
    {               
        System.out.println("test value is empty - test start");
        assertTrue(value.isEmpty(), "value is not empty.");
        System.out.println("test value is empty - test end");       
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
    
    @Test(description="check value is empty no DP", groups = {"testempty", "testemptynodp", "afterfix"})
    public void testValueIsEmpty2()
    {              
        String value = "";
        System.out.println("Start - sample test");
        assertTrue(value.isEmpty(), "value is not empty.");
        System.out.println("End - sample test");        
    }
}
