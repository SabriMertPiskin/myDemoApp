package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testMeaningfulOperation_AllInputsInRange() {
      String[] s = {"a", "b", "c", "d", "e"};
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(0,2,4));
      Integer[] arr = {1,3};
      int a = 2;
      assertEquals(new App().meaningfulOperation(array,arr,a,s),"acebdc");
    }

    public void testMeaningfulOperation_NullArrayInputs() {
        ArrayList<Integer> array = new ArrayList<>();
        Integer[] arr = {};
        int a = 0;
        String[] s = {"a", "b", "c", "d", "e"};
        assertEquals("a", new App().meaningfulOperation(array,arr,a,s));
    }

   
    public void testMeaningfulOperation_EmptyInputArrays() {
        ArrayList<Integer> array = null;
        Integer[] arrInt = null;
        int i = 0;
        String[] strArr = {"a", "b", "c", "d", "e"};
        assertEquals("a", App.meaningfulOperation(array, arrInt, i, strArr));
    }


    
    public void testMeaningfulOperation_IndexEqualsStringLength() {
        ArrayList<Integer> array = new ArrayList<>(List.of(0, 2, 4));
        Integer[] arrInt = {1, 3};
        int i = 5; // 5 is out of range, should not be concatenated
        String[] strArr = {"a", "b", "c", "d", "e"};
        assertEquals("acebd", App.meaningfulOperation(array, arrInt, i, strArr));
    }

}