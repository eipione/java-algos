package co.eipi.java.algo.stack.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.stack.IStack;
import co.eipi.java.algo.stack.Stack;
import co.eipi.java.algo.test.TestUtils;

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
