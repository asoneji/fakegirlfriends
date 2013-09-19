package com.intuit.ctodev.qa.iday.library;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.ITest;

public class SolutionTwo implements ITest {
	// ABSTRACT PORTION
	protected Data testInputs;
	protected Object[][] dp;

	public String getTestName() {
		return testInputs.getDescription();
	}

	public SolutionTwo() {
	}

	public SolutionTwo(Data params) {
		this.testInputs = params;
		this.dp = new Object[][] { this.testInputs.data };
	}

	@DataProvider(name = "FakeGirlfriendsDataProvider")
	public Object[][] getDP() {
		return dp;
	}

	// SUBCLASS PORTION
	@Test(groups = { "dptest", "solutiontwo" })
	public void actualTestMethod(Object value) {
		assertTrue(value != null, "value is null.");
	}

	public Object[] createData() {
		return new Object[] {
				new Data(new Object[] { "test1" }, "regular string"),
				new Data(new Object[] { " test2 " }, "string trailing spaces"),
				new Data(new Object[] { null }, "null"),
				new Data(new Object[] { " " }, "empty string with space"),
				new Data(new Object[] { "" }, "empty string"),
				new Data(new Object[] { new ArrayList<Object>(5) }, "ArrayList"),
				new Data(new Object[] { new Object[] { "Hello", "World!" } },
						"Object[]") };
	}

	@Factory
	public Object[] createInstances() {
		Object[] data = this.createData();
		Object[] result = new Object[data.length];
		int i = 0;

		for (Object input : data) {
			result[i++] = new SolutionTwo((Data) input);
		}

		return result;
	}

	// EXTRA CLASS
	protected class Data {
		protected String description;
		protected Object[] data;

		public Data(Object[] data, String desc) {
			this.description = desc;
			this.data = data;
		}

		public String getDescription() {
			return description;
		}

		public Object[] getData() {
			return data;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setData(Object[] data) {
			this.data = data;
		}
	}
}
