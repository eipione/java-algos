package com.ephipi.java.algo.linkedlist;

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
     * Delete the first occurrence of the given data value
     * @param data
     * @return new Head (because the head might change)
     */
    public static Node deleteNode(Node head,int data)
    {
	if (head == null) return head;
	if (head.data == data)
	{
	    head = head.next;
	}
	else
	{
	    Node prev = head;
	    Node temp = head.next;
	    
	    while(temp != null)
	    {
		if (temp.data == data)
		{
		   prev.next = temp.next; 
		   break;
		}
		prev = temp;
		temp = temp.next;
	    }
	}
	return head;
    }
    
    /**
     * 
     * @param head
     * @return the tail
     */
    public static Node getTail(Node head)
    {
	while(head.next !=null)
	{
	    head = head.next;
	}
	
	return head;
    }
    
    public static Node getNth(Node head,int n)
    {
	for(int i=0;i<n && head!=null;i++)
	{
	    head = head.next;
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
