package com.ephipi.java.algo.strings.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.java.algo.strings.StringRotation;
import com.ephipi.java.algo.test.TestUtils;

public class TestStringRotation
{

    @Test
    public void testRotateTrue()
    {
	int size = 100;

	List<String> original = TestUtils.genRandomStringList(size, 10);
	List<String> rotated = new ArrayList<String>(size);

	for (String orig : original)
	{
	    rotated.add(TestUtils.rotateString(orig));
	}

	System.out.println(original);
	System.out.println(rotated);

	for (int i = 0; i < size; i++)
	{
	    Assert.assertTrue("Rotation Test Failed for " + original.get(i)
		    + "," + rotated.get(i), StringRotation.isRotationOf(
		    original.get(i), rotated.get(i)));
	}

	Assert.assertTrue("Rotation Positive Test Failed for " + null + "," + null,
		StringRotation.isRotationOf(null, null));

    }

    @Test
    public void testRotateFalse()
    {

	List<String> original = new ArrayList<String>();
	List<String> rotated = new ArrayList<String>();

	original.add(null);
	rotated.add("");

	original.add(null);
	rotated.add("ok");

	original.add("");
	rotated.add("ok");

	original.add("abc");
	rotated.add("abcd");

	original.add("abc");
	rotated.add("cba");

	System.out.println(original);
	System.out.println(rotated);

	for (int i = 0; i < original.size(); i++)
	{
	    Assert.assertFalse("Rotation Negative Test Failed for " + original.get(i)
		    + "," + rotated.get(i), StringRotation.isRotationOf(
		    original.get(i), rotated.get(i)));
	}
    }
}
