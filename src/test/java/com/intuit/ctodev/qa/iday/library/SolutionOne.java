package com.intuit.ctodev.qa.iday.library;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.ITest;

public class SolutionOne {
	protected static int nextId;
	
	static{
        nextId = 1;
    }
	
	public Object[] createData() {
		return new Object[] { 
				new Data("test1", "regular string"), 
				new Data(" test2 ", "string trailing spaces"), 
				new Data(null, "null"), 
				new Data(" ", "empty string with space"), 
				new Data("", "empty string"),  
				new Data(new ArrayList<Object>(5), "ArrayList"), 
				new Data(new Object[] { "Hello", "World!" }, "Object[]")
		};
	}
	
	// Unused
	public Object[][] dataProvider() {
		return new Object[][] { 
				{ "test1", "regular string"}, 
				{ " test2 ", "string trailing spaces" }, 
				{ null, "null"}, 
				{ " ", "empty string with space" },
				{ "", "empty string" },  
				{ new ArrayList<Object>(5), "ArrayList" },
				{ new Object[] { "Hello", "World!" }, "Object[]" }
		};
	}

	@Factory
	public Object[] createInstances() {
		Object[] data = this.createData();
		Object[] result = new Object[data.length];
		int i = 0;
		
		for (Object input : data) {
			result[i++] = new TestValueIsNotNullTest((Data)input);
		}
		
		return result;
	}

	protected class TestValueIsNotNullTest implements ITest {
		private Data testInputs;

		public TestValueIsNotNullTest(Data inputs) {
			testInputs = inputs;
		}

		@Test(groups = { "dptest", "solutionone" })
		public void actualTestMethod() {
			Object value = testInputs.getData();
			assertTrue(value != null, "value is null.");
		}
		
		public String getTestName() {
			return testInputs.getDescription();
		}
	}
	
	protected class Data
	{	
		protected int id;
		protected String description;
		protected Object data;
		
		/**
		 * 
		 * @param datam The data to be 
		 * @param desc
		 * 
		 */
		
		public Data(Object datam, String desc)
		{
			this(datam, nextId++, desc);
		}
		public Data(Object data, int id, String desc)
		{
			this.id = id;
			this.description = desc;
			this.data = data;
		}
		
		public int getId() {
			return id;
		}
		
		public String getDescription() {
			return description;
		}
		
		public Object getData() {
			return data;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setData(Object data) {
			this.data = data;
		}
	}
}
