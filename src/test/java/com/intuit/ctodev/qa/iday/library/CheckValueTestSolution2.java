package com.intuit.ctodev.qa.iday.library;

import static org.testng.Assert.assertTrue;

import org.testng.ITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.intuit.ctodev.qa.iday.placeholder.TestDetail;

public class CheckValueTestSolution2 implements ITest
{
    CheckValueTestSolution2()
    {
        
    }
    
    private String testValue;
    private String testName;
    
    @Factory(dataProvider = "testDP")
    public CheckValueTestSolution2(TestDetail testDetail, String value) 
    {
        testValue = value;
        testName = testDetail.getTestCaseName();
    }    

    @Test(description="check value not null", groups = { "dptest", "solution2"})
    public void testValueIsNotNull()
    {               
        System.out.println("Start - sample test");
        assertTrue(testValue != null, "value is null.");
        System.out.println("End - sample test");        
    }   
    
    @DataProvider(name = "testDP")
    public Object[][] testDP()
    {
        return new Object[][]
        {
                { new TestDetail("regular string"), "test1"}, //regular string
                { new TestDetail("string trailing spaces"), " test2 "}, //string trailing spaces
                { new TestDetail("test value is: null"), null }, //null
                { new TestDetail("empty string with space"), " "}, //empty string with space
                { new TestDetail("empty string"), ""}, //empty string
        };
    }

    public String getTestName()
    {
        // TODO Auto-generated method stub
        return testName;
    }
}
