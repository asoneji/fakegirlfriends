package com.intuit.ctodev.qa.iday.placeholder;

import java.lang.reflect.Method;
import java.util.Set;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoTestName
{

    @Test(groups = {"demotestname"})
    public void foo(Method currentMethod)
    {
        Set<String> test = Reporter.getCurrentTestResult().getAttributeNames();
        for (String value : test)
        {
            System.out.println("++++++++++++++++value: " + value);
        }
        Reporter.getCurrentTestResult().setAttribute(currentMethod.getName(), "Hello World");
        
    }

    @Test(groups = {"demotestname"})
    public void bar(Method currentMethod)
    {

        Reporter.getCurrentTestResult().setAttribute(currentMethod.getName(), "Another test");

    }

    @AfterMethod
    public void foobar(ITestResult result)
    {

        System.out.println(result.getName());

        System.out.println(result.getAttribute(result.getName()));

    }

}
