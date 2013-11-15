package co.eipi.java.algo.linkedlist.test;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.linkedlist.LinkedList;
import co.eipi.java.algo.linkedlist.ListReverse;
import co.eipi.java.algo.linkedlist.LinkedList.Node;
import co.eipi.java.algo.test.TestUtils;

public class TestListReverse
{

    @Test
    public void testReverse()
    {
	List<Integer> randList = TestUtils.genRandomArray(1000, 10000);
	Node head = LinkedList.createList(randList);
	head = ListReverse.reverse(head);
	List<Integer> retList = LinkedList.getDataList(head);
	Collections.reverse(randList);
	Assert.assertEquals(randList, retList);
    }
}
