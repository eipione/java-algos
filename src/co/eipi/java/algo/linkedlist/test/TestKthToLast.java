package co.eipi.java.algo.linkedlist.test;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import co.eipi.java.algo.linkedlist.KthToLast;
import co.eipi.java.algo.linkedlist.LinkedList;
import co.eipi.java.algo.linkedlist.LinkedList.Node;
import co.eipi.java.algo.test.TestUtils;

public class TestKthToLast
{

    @Test
    public void testKthToLast()
    {
	List<Integer> randList = TestUtils.genRandomArray(10, 10000);
	Node head = LinkedList.createList(randList);

	for (int i = 0; i < randList.size(); i++)
	{
	    int k = randList.size() - i ;
	    Integer expectedValue = randList.get(i);
	    Integer actualValue = KthToLast.find(head, k).data;
	    Assert.assertEquals(expectedValue, actualValue);
	}
	
	Assert.assertNull(KthToLast.find(head, randList.size()+ 1));
	Assert.assertNull(KthToLast.find(head, randList.size() + 1+ new Random().nextInt(10)));
    }
}
