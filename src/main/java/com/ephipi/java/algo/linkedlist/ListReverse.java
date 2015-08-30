package com.ephipi.java.algo.linkedlist;

import com.ephipi.java.algo.linkedlist.LinkedList.Node;

public class ListReverse
{

    public static Node reverse(Node head)
    {
	if (head == null || head.next == null)
	    return head;

	// Define prev2 as the node before the previous node
	Node prev2 = null;
	
	// The previous node 
	Node prev1 = head;
	
	// Invariant: prev1 is the pointer to the head of remaining not-reversed list
	// and, prev2 is pointer to the head of reversed list

	// Continue till we hit null
	while (prev1 != null)
	{
	    
	    // Set the current to the prev1.next, 
	    Node current = prev1.next;
	    
	    // Now we can point prev1 to its new next (in the reversed list)
	    prev1.next = prev2;

	    // Move prev2 and prev1 one step down the linked list
	    
	    // prev1's link has been reversed and it is the new head of the reversed list
	    prev2 = prev1;
	    
	    // And the current is the new head of the not-reversed list
	    prev1 = current;

	}

	return prev2;
    }
}
