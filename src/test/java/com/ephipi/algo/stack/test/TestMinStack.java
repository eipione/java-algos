package com.ephipi.algo.stack.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.algo.stack.MinStack;
import com.ephipi.algo.test.TestUtils;

public class TestMinStack
{

    public Integer findMin(List<Integer> numbers, int endIndex)
    {
	List<Integer> newList = new ArrayList<Integer>();
	for (int i = 0; i <= endIndex; i++)
	{
	    newList.add(numbers.get(i));
	}
	return Collections.min(newList);
    }
    

    @Test
    public void testStack()
    {
	List<Integer> numbers = TestUtils.genRandomList(1000, 10);

	MinStack<Integer> stack = new MinStack<Integer>();

	for (Integer number : numbers)
	{
	    stack.push(number);
	}

	for (int i = numbers.size() - 1; i >= 0; i--)
	{

	    Assert.assertEquals(findMin(numbers, i), stack.min());

	    Assert.assertEquals(numbers.get(i), stack.peek());
	    Assert.assertEquals(numbers.get(i), stack.pop());

	}

	Assert.assertNull(stack.peek());
	Assert.assertNull(stack.pop());
	Assert.assertNull(stack.min());
	Assert.assertTrue(stack.isEmpty());
	stack.toString();
    }
}
