package com.ephipi.java.algo.linkedlist;

import com.ephipi.java.algo.linkedlist.LinkedList.Node;

public class KthToLast
{

    public static Node find(Node head, int k)
    {

	Node ptr = head;
	Node ret = head;

	// Advance ptr by K -1 steps
	for (int i = 0; i < k -1; i++)
	{
	    if (ptr == null)
		return null;
	    ptr = ptr.next;
	}

	// If we hit end of the list, return null
	if (ptr == null)
	    return null;

	// Move both till you reach the last element
	while (ptr.next != null)
	{
	    ret = ret.next;
	    ptr = ptr.next;
	}

	// Now return Kth to last
	return ret;
    }

}
