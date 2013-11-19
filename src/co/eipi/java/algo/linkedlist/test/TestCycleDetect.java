package co.eipi.java.algo.linkedlist.test;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.linkedlist.CycleDetect;
import co.eipi.java.algo.linkedlist.LinkedList;
import co.eipi.java.algo.linkedlist.LinkedList.Node;
import co.eipi.java.algo.test.TestUtils;

public class TestCycleDetect
{

    @Test
    public void testCycleDetect()
    {
	List<Integer> randList = TestUtils.genRandomArray(100, 1000);
	Node head = LinkedList.createList(randList);

	Node tail = LinkedList.getTail(head);

	int rnd = new Random().nextInt(randList.size());

	Node rndNode = LinkedList.getNth(head, rnd);

	tail.next = rndNode;

	Node cycleHead = CycleDetect.detect(head);

	Assert.assertEquals(rndNode, cycleHead);

    }

    @Test
    public void testNoCycle()
    {
	List<Integer> randList = TestUtils.genRandomArray(100, 1000);
	Node head = LinkedList.createList(randList);

	Node cycleHead = CycleDetect.detect(head);

	Assert.assertNull(cycleHead);

    }
}
