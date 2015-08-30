package com.ephipi.algo.stack.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.algo.stack.IStack;
import com.ephipi.algo.stack.Stack;
import com.ephipi.algo.test.TestUtils;

public class TestStack
{

    @Test
    public void testStack()
    {
	List<Integer> numbers = TestUtils.genRandomList(100, 1000);
	
	IStack<Integer> stack = new Stack<Integer>();
	
	for(Integer number:numbers)
	{
	    stack.push(number);
	}
	
	stack.toString();
	
	for(int i=numbers.size() -1;i>=0;i--)
	{
	    Assert.assertEquals(numbers.get(i), stack.peek());
	    Assert.assertEquals(numbers.get(i), stack.pop());
	}
	
	Assert.assertNull(stack.peek());
	Assert.assertNull(stack.pop());
	
    }
}
