package com.intuit.ctodev.qa.iday.placeholder;
/*
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.ITest;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CarsAndTravelIT2 implements ITest {

    private static final ThreadLocal<String> testName =
        new ThreadLocal<String> () {
            @Override
            protected String initialValue() {
                return "undefinedTestName";
            }
        };

    private void performTestAndAssert(TestNG testSpec)
    {
        // TODO Auto-generated method stub
    }        

    @DataProvider(name = "testSpec")
    public Iterator<Object[]> createData(Method method) {
        // Retrieve the suite name from the annotation and pass it to the iterator which loads the input files within the test suite folder.
        return new TestSpecIterator(method.getName(), method.getAnnotation(TestSuite.class).suiteName());
    }

    @TestSuite(suiteName = "cars")
    @Test(dataProvider = "testSpec")
    public void carsTestSuite(TestNG testSpec) throws Exception {
        performTestAndAssert(testSpec);
    }

    @TestSuite(suiteName = "travel")
    @Test(dataProvider = "testSpec")
    public void travelTestSuite(TestNG testSpec) throws Exception {
        performTestAndAssert(testSpec);
    }

    public String getTestName() {
        return testName.get();
    }

    @Retention(RetentionPolicy.RUNTIME)
    protected @interface TestSuite {
        String suiteName();
    }

    protected class TestSpecIterator implements Iterator<Object[]> {

        protected TestSpecIterator(String suiteMethodName, String suiteName) 
        {
            //something
        }
        
        public boolean hasNext()
        {
            // TODO Auto-generated method stub
            return false;
        }

        public void remove()
        {
            // TODO Auto-generated method stub
            
        }        

        @Override
        public Object[] next() {
            // We're assuming the caller has called hasNext() before calling this method.
            TestSpec next = fileIterator.next();
            // Set the test name from the suite method name and the input file name, since this is called
            // right before getTestName().
            testName.set(suiteMethodName + "-" + next.getInputFile().getName());
            return new Object[] {next};
        }
    }
}
*/