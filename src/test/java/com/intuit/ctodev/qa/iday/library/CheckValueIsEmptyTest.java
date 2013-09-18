package com.intuit.ctodev.qa.iday.library;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckValueIsEmptyTest
{

    @Test(description="value is empty", groups = { "dptest", "testempty"}, dataProvider = "testDP")
    public void testValueIsEmpty(String value)
    {       
        System.out.println("Start - sample test");
        assertTrue(value.isEmpty(), "value is not empty.");
        System.out.println("End - sample test");
    }
    
    @DataProvider(name = "testDP")
    //@Parameters TestInstance
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
