package co.eipi.java.algo.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList
{

    public static class Node
    {
	public int data;
	public Node next;

    }

    /**
     * Create a Singly linked list from the given dataList, preserving the
     * order
     * Returns Null for an empty list
     * @param dataList
     * @return The head of the created LinkedList
     */
    public static Node createList(List<Integer> dataList)
    {
	Iterator<Integer> it = dataList.iterator();
	
	Node head = null;
	Node prev = null;

	if (it.hasNext())
	{
	    head = new Node();
	    head.data = it.next();
	    prev = head;
	}
	
	while(it.hasNext())
	{
	    Node node = new Node();
	    node.data = it.next();
	    prev.next = node;
	    prev = node;
	}

	return head;

    }

    /**
     * Create a list of integer from the given node to null
     * or empty list if the given node is null
     * @param node
     * @return List of integers in order
     */
    public static List<Integer> getDataList(Node node)
    {
	List<Integer> list = new ArrayList<Integer>();
	while (node != null)
	{
	    list.add(node.data);
	    node = node.next;
	}
	return list;
    }
    

}
