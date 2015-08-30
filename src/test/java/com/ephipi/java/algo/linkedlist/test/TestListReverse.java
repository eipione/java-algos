package com.ephipi.java.algo.linkedlist.test;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.java.algo.linkedlist.LinkedList;
import com.ephipi.java.algo.linkedlist.ListReverse;
import com.ephipi.java.algo.linkedlist.LinkedList.Node;
import com.ephipi.java.algo.test.TestUtils;

public class TestListReverse
{

    @Test
    public void testReverse()
    {
	List<Integer> randList = TestUtils.genRandomList(1000, 10000);
	Node head = LinkedList.createList(randList);
	head = ListReverse.reverse(head);
	List<Integer> retList = LinkedList.getDataList(head);
	Collections.reverse(randList);
	Assert.assertEquals(randList, retList);
    }
}
