package co.eipi.java.algo.queue.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.queue.IQueue;
import co.eipi.java.algo.queue.Queue;
import co.eipi.java.algo.queue.QueueOfStacks;
import co.eipi.java.algo.test.TestUtils;

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
