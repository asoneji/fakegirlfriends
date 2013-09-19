package com.intuit.ctodev.qa.iday.placeholder;

import static org.testng.Assert.assertTrue;

import org.testng.ITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckValueIsNotNullTest2 implements ITest
{

    @Test(description="check value not null", groups = { "dptest2", "testnull2"}, dataProvider = "testDP")
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

    public String getTestName()
    {
        // TODO Auto-generated method stub
        return null;
    } 
}
