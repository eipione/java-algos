package co.eipi.java.algo.linkedlist.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.linkedlist.LinkedList;
import co.eipi.java.algo.linkedlist.LinkedList.Node;
import co.eipi.java.algo.test.TestUtils;

public class TestLinkedList
{

    @Test
    public void testCreateAndGet()
    {
	List<Integer> randList = TestUtils.genRandomArray(100, 1000);
	Node head = LinkedList.createList(randList);
	List<Integer> retList = LinkedList.getDataList(head);
	Assert.assertEquals(randList, retList);
    }
}
