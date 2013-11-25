package co.eipi.java.algo.queue.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.queue.Queue;
import co.eipi.java.algo.test.TestUtils;

public class TestQueue
{

    @Test
    public void testQueue()
    {
	List<Integer> numbers = TestUtils.genRandomList(100, 1000);

	Queue<Integer> queue = new Queue<Integer>();

	for (Integer number : numbers)
	{
	    queue.enqueue(number);
	}
	
	for (Integer number : numbers)
	{
	    Assert.assertEquals(number, queue.peek());
	    Assert.assertEquals(number, queue.dequeue());
	}


	Assert.assertNull(queue.peek());
	Assert.assertNull(queue.dequeue());
    }
}
