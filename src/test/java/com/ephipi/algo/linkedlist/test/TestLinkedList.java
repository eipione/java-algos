package com.ephipi.algo.linkedlist.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.algo.linkedlist.LinkedList;
import com.ephipi.algo.linkedlist.LinkedList.Node;
import com.ephipi.algo.test.TestUtils;

public class TestLinkedList
{

    @Test
    public void testCreateAndGet()
    {
	List<Integer> randList = TestUtils.genRandomList(100, 1000);
	Node head = LinkedList.createList(randList);
	List<Integer> retList = LinkedList.getDataList(head);
	Assert.assertEquals(randList, retList);
    }

    @Test
    public void testDeleteNodeFirstElement()
    {
	List<Integer> randList = TestUtils.genRandomList(100, 1000);
	Node head = LinkedList.createList(randList);

	Integer firstElement = randList.remove(0);
	head = LinkedList.deleteNode(head, firstElement);
	Assert.assertEquals(randList, LinkedList.getDataList(head));
    }

    @Test
    public void testDeleteNodeLastElement()
    {
	List<Integer> randList = new ArrayList<Integer>();
	randList.addAll(Arrays.asList(1, 2, 3, 56));

	Node head = LinkedList.createList(randList);

	Integer elementToRemove = randList.remove(randList.size() - 1);
	head = LinkedList.deleteNode(head, elementToRemove);
	Assert.assertEquals(randList, LinkedList.getDataList(head));
    }
    
    @Test
    public void testDeleteRandomElement()
    {
	List<Integer> randList = new ArrayList<Integer>();
	randList.addAll(Arrays.asList(1, 2, 3, 56,34,35,4,7));

	Node head = LinkedList.createList(randList);

	Integer elementToRemove = randList.remove(new Random().nextInt(randList.size()));
	head = LinkedList.deleteNode(head, elementToRemove);
	Assert.assertEquals(randList, LinkedList.getDataList(head));
    }
    
    @Test
    public void testElementNotFound()
    {
	List<Integer> randList = new ArrayList<Integer>();
	randList.addAll(Arrays.asList(1, 2, 3, 56,34,35,4,7));

	Node head = LinkedList.createList(randList);

	head = LinkedList.deleteNode(head, 9999);
	Assert.assertEquals(randList, LinkedList.getDataList(head));
    }
}
