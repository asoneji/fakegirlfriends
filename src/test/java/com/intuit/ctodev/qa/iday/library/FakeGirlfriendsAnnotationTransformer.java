package com.intuit.ctodev.qa.iday.library;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class FakeGirlfriendsAnnotationTransformer implements IAnnotationTransformer
{
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		// TODO Auto-generated method stub
		annotation.setDataProvider("FakeGirlfriendsDataProvider");
	}

}
