package com.ephipi.java.algo.misc;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTop4Largest
{

    @Before
    public void before()
    {
	System.out.println("Before");
    }

    @After
    public void after()
    {
	System.out.println("after");
    }

    @Test
    public void testBasic()
    {
	List<Integer> inList = Arrays.asList(1000, 4, 565, 434, 1, 2, 4545,
		767, 2, -1, -100);

	List<Integer> large4 = Top4Largest.top4(inList);

	List<Integer> expected = Arrays.asList(565, 767, 1000, 4545);

	Assert.assertEquals("Result not as expected", expected, large4);
    }

    @Test
    public void testWith3()
    {
	List<Integer> inList = Arrays.asList(1000, 4, 565);

	List<Integer> large4 = Top4Largest.top4(inList);

	List<Integer> expected = Arrays.asList(4, 565, 1000);

	Assert.assertEquals("Result not as expected", expected, large4);
    }

    @Test
    public void testEmpty()
    {
	List<Integer> inList = Arrays.asList();

	List<Integer> large4 = Top4Largest.top4(inList);

	List<Integer> expected = Arrays.asList();

	Assert.assertEquals("Result not as expected", expected, large4);
    }

    @Test(expected = NullPointerException.class)
    public void testNull()
    {
	List<Integer> inList = null;
	@SuppressWarnings("unused")
	List<Integer> large4 = Top4Largest.top4(inList);

    }

}
