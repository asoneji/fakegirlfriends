package com.intuit.ctodev.qa.iday.placeholder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Set;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving detailLogTest events.
 * The class that is interested in processing a detailLogTest
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addDetailLogTestListener<code> method. When
 * the detailLogTest event occurs, that object's appropriate
 * method is invoked.
 *
 * @see DetailLogTestEvent
 * @author asoneji
 */
public class DetailLogTestListener extends TestListenerAdapter implements ITest
{
    
    /** The Constant PASSED. */
    public static final String PASSED = "PASSED";
    
    /** The Constant FAILED. */
    public static final String FAILED = "FAILED";
    
    /** The Constant SKIPPED. */
    public static final String SKIPPED = "SKIPPED";
    
    
    @Override
    public void onStart(ITestContext testContext)
    {
        System.out.println("=========================Starting a suit");
        super.onStart(testContext);
    }
    
    @Override
    public void onTestStart(ITestResult result)
    {
     /*  
        System.out.println("=========================Starting a test");
        System.out.println("+++++++++++++++++++++in onTestStart");
        //Object[] parameters = null;
        //result.setParameters(parameters);
        result.setAttribute("name", "name HELOO!!!!!!!!!!!!!!!");
        result.setAttribute("testName", "HELOO!!!!!!!!!!!!!!!");
        result.setAttribute("m_name", "HELOO!!!!!!!!!!!!!!!");
        result.setAttribute("m_testName", "HELOO!!!!!!!!!!!!!!!");      
        
        Set<String> names = result.getAttributeNames();
        
        for (String name : names)
        {
            System.out.println("name is: " + name);
        }
        */
        System.out.println( "++++++++++++++++++++++++Result: " + result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
        super.onTestStart(result);
    }
    /* (non-Javadoc)
     * @see org.testng.TestListenerAdapter#onTestFailure(org.testng.ITestResult)
     */
    @Override
    public void onTestFailure(ITestResult tr)
    {
        prettyPrintTest(tr, FAILED);
        super.onTestFailure(tr);
    }
    
    /* (non-Javadoc)
     * @see org.testng.TestListenerAdapter#onTestSuccess(org.testng.ITestResult)
     */
    @Override
    public void onTestSuccess(ITestResult tr)
    {
        prettyPrintTest(tr, PASSED);
        super.onTestSuccess(tr);
    }
    
    /* (non-Javadoc)
     * @see org.testng.TestListenerAdapter#onTestSkipped(org.testng.ITestResult)
     */
    @Override
    public void onTestSkipped(ITestResult tr)
    {
        prettyPrintTest(tr, SKIPPED);
        super.onTestSkipped(tr);
    }
    
    /**
     * Pretty print test fail test case.
     *
     * @param tr the test result
     * @author asoneji
     */
    private void prettyPrintTestFailTestCase(ITestResult tr)
    {
        Throwable errorMsg = tr.getThrowable();
        System.out.println(errorMsg.getClass().getCanonicalName() + ": " + errorMsg.getMessage());
        System.out.println(getStackTraceAsString(errorMsg));
    }
    
    /**
     * Gets the stack trace as string.
     *
     * @param throwable the Exception
     * @return the stack trace as string
     * @author asoneji
     */
    public static String getStackTraceAsString(Throwable throwable)
    {
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        throwable.printStackTrace(pw);
        
        return sw.getBuffer().toString();
    }    
    
    /* (non-Javadoc)
     * @see org.testng.TestListenerAdapter#onFinish(org.testng.ITestContext)
     */
    @Override
    public void onFinish(ITestContext testContext)
    {
        Set<ITestResult> passRunResult = testContext.getPassedTests().getAllResults();
        Set<ITestResult> failRunResult = testContext.getFailedTests().getAllResults();
        Set<ITestResult> skippedRunResult = testContext.getSkippedTests().getAllResults();
        
        int passedTests = testContext.getPassedTests().size();
        int failedTests = testContext.getFailedTests().size();
        int skippedTests = testContext.getSkippedTests().size();
        int totalTests = passedTests + failedTests + skippedTests;
        System.out.println("\n===============================================\nTotal Run : " + totalTests + ", Passed: " + passedTests + ", Failed: " + failedTests + ", Skip: " + skippedTests+"\n===============================================");
        
        System.out.println("\n===============================================");
        printResult(passRunResult, PASSED);
        printResult(skippedRunResult, SKIPPED);
        printResult(failRunResult, FAILED);
        System.out.println("\n===============================================");
        
        super.onFinish(testContext);
        
    }
    
    
    
    /**
     * Prints the result.
     *
     * @param runResult the run result
     * @param testStatus the test status
     * @author asoneji
     */
    private void printResult(Set<ITestResult> runResult, String testStatus)
    {
        for (Iterator<ITestResult> runResultIterator = runResult.iterator(); runResultIterator.hasNext();)
        {
            ITestResult iTestResult = (ITestResult) runResultIterator.next();
            prettyPrintTest(iTestResult, testStatus);
        }
        
    }



    /**
     * Pretty print test.
     *
     * @param tr the tr
     * @param testStatus the test status
     * @author asoneji
     */
    private void prettyPrintTest(ITestResult tr, String testStatus)
    {
        String params = getTestParams(tr);
        System.out.println(testStatus + ": " + tr.getName() + "("+params+")");
        
        if(testStatus.equals(FAILED))
        {
            prettyPrintTestFailTestCase(tr);
        }
    }

    /**
     * Gets the test params.
     *
     * @param tr the tr
     * @return the test params
     * @author asoneji
     */
    private String getTestParams(ITestResult tr)
    {
        StringBuffer parmsSB = new StringBuffer();
        Object[] params = tr.getParameters();
        for (int i = 0; i < params.length; i++)
        {
            if(i == 0 || (i == params.length))
            {
                parmsSB.append("\""+params[i]+"\"");
            }
            else
            {
                parmsSB.append(", \"" + params[i] + "\"");
            }
                
            
        }
        return parmsSB.toString();
    }

    public String getTestName()
    {
        ITest m_instance = null;
        Object m_testName = null;
        if (m_testName == null && m_instance instanceof ITest) {
            return ((ITest) m_instance).getTestName();
          }
         return null;
          
        // TODO Auto-generated method stub
        /*
        try
        {
            Thread.sleep(20);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("+++++++++++++++++++++in getTestName");
        return "HELLLO" + System.currentTimeMillis();
        */
    }
}