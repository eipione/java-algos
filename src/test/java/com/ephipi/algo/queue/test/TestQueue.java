package com.ephipi.algo.queue.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.algo.queue.IQueue;
import com.ephipi.algo.queue.Queue;
import com.ephipi.algo.queue.QueueOfStacks;
import com.ephipi.algo.test.TestUtils;

public class TestQueue
{

    @Test
    public void testQueueOfStacks()
    {
	testQueue(new QueueOfStacks<Integer>());

    }
    
    @Test
    public void testQueue()
    {
	testQueue(new Queue<Integer>());

    }

    private void testQueue(IQueue<Integer> queue)
    {
	List<Integer> numbers = TestUtils.genRandomList(100, 1000);

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
