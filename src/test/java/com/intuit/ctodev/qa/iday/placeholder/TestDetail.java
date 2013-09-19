package com.intuit.ctodev.qa.iday.placeholder;

public class TestDetail
{
    private String testCaseName = null;

    public String getTestCaseName()
    {
        return testCaseName;
    }

    private void setTestCaseName(String testCaseName)
    {
        this.testCaseName = testCaseName;
    }
    
    public static TestDetail getTestCase(String testCaseDetail)
    {
        TestDetail test = new TestDetail();
        test.setTestCaseName(testCaseDetail);
       
        return test;
    }

    public TestDetail getTestCase2(String testCaseDetail)
    {
        TestDetail test = new TestDetail();
        test.setTestCaseName(testCaseDetail);
       
        return test;
    }
}
