package com.intuit.ctodev.qa.iday.before;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckValueTest
{

    @Test(description="check value not null", groups = { "testnull", "beforefix"}, dataProvider = "testDP")
    public void testValueIsNotNull(String value)
    {               
        System.out.println("test value not null - test start");
        assertTrue(value != null, "value is null.");
        System.out.println("test value not null - test end");        
    }
    
    @Test(description="check all char in value are uppercase", groups = { "testuppercase", "beforefix"}, dataProvider = "testDP2")
    public void testValueIsUppercase(String value, int dummyData)
    {               
        System.out.println("test value is upper case - test start");
        assertTrue(isAllUpper(value), "value is null.");
        System.out.println("test value is upper case - test end");        
    }    
    
    private static boolean isAllUpper(String s) 
    {
        for(char c : s.toCharArray()) 
        {
           if(Character.isLetter(c) && Character.isLowerCase(c)) {
               return false;
            }
        }
        return true;
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
    
    @DataProvider(name = "testDP2")
    public Object[][] testDP2()
    {
        return new Object[][]
        {
                { "TEST1", 1}, //regular string
                { " TEST2 ", 2}, //string trailing spaces
                { null , 3}, //null
                { " ", 4}, //empty string with space
                { "", 5}, //empty string
        };
    }    
}
