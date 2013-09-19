package com.intuit.ctodev.qa.iday.placeholder;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;


public class CheckValueIsNotNullTest3 implements ITest
{
    String testDetail = "HELLO";

    @BeforeMethod(alwaysRun = true)
    public void testData(Method method, Object[] testData)
    {
        testDetail = getTestName();
    }    
    
    @Test(description="check value not null", groups = { "dptest3", "testnull3"}, dataProvider = "testDP")
    public void testValueIsNotNull(TestDetail detailTest, String value) throws ClassNotFoundException
    {
        testDetail = detailTest.getTestCaseName();
        
        System.out.println("==========TEST DETAIL: " + testDetail);
        //this.context.setAttribute("name", "");
        //this.setTestName(testDetail);
        System.out.println("Start - sample test");
        assertTrue(value != null, "value is null.");
        System.out.println("End - sample test");        
    }

    @DataProvider(name = "testDP")
    public Object[][] testDP()
    {
        return new Object[][]
        {
                { TestDetail.getTestCase("regular string"), "test1"}, //regular string
                { TestDetail.getTestCase("string trailing spaces"), " test2 "}, //string trailing spaces
                { TestDetail.getTestCase("null"), null }, //null
                { TestDetail.getTestCase("empty string with space"), " "}, //empty string with space
                { TestDetail.getTestCase("empty string"), ""}, //empty string
        };
    }

    @DataProvider(name = "testDP")
    public Object[][] testDP2()
    {
        return new Object[][]
        {
                { "test2", "test1"}, //regular string
        };
    }
    
    public String getTestName()
    {
        // TODO Auto-generated method stub
        System.out.println("=============Get Test Name Called: " + testDetail);
        return testDetail;
    }
}
