package com.intuit.ctodev.qa.iday.after;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class IDayTest
{    
    @Test(description="Check Innovation Day Rocks!", groups = { "iday", "afterfix"})
    public void testValueIsEmpty2()
    {              
        System.out.println("Innovation day rocks! - test start");
        assertTrue(true, "Innovation does not rock!");
        System.out.println("Innovation day rocks! - test end");        
    }
}
