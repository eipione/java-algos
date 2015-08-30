package com.ephipi.java.algo.tree;

import java.util.ArrayList;
import java.util.List;

import com.ephipi.java.algo.queue.IQueue;
import com.ephipi.java.algo.queue.Queue;
import com.ephipi.java.algo.tree.BinaryTree.Node;

public class BinaryTreeTraverse
{

    public static enum Order
    {
	IN_ORDER, PRE_ORDER, POST_ORDER, LEVEL_ORDER
    }

    /**
     * Return the in-order path for the given binary tree
     * 
     * @param tree
     * @return
     */
    public static <T> List<T> order(BinaryTree<T> tree, Order order)
    {
	List<T> retList = new ArrayList<T>();
	if (tree.root != null)
	{
	    switch (order)
	    {
		case IN_ORDER:
		    inOrder(tree.root, retList);
		    break;

		case LEVEL_ORDER:
		    levelOrder(tree.root, retList);
		    break;
		case POST_ORDER:
		    postOrder(tree.root, retList);
		    break;
		case PRE_ORDER:
		    preOrder(tree.root, retList);
		    break;
		default:
		    break;

	    }

	}

	return retList;
    }

    /**
     * Traverse In-Order left child, Node, right child
     * 
     * @param node
     *            - The node to be traversed
     * @param retList
     *            - The list in which the data is to be added
     */
    private static <T> void inOrder(Node<T> node, List<T> retList)
    {
	if (node.left != null)
	{
	    inOrder(node.left, retList);
	}
	retList.add(node.data);

	if (node.right != null)
	{
	    inOrder(node.right, retList);
	}

    }

    /**
     * Traverse Pre-Order Node, left child, right child
     * 
     * @param node
     *            - The node to be traversed
     * @param retList
     *            - The list in which the data is to be added
     */
    private static <T> void preOrder(Node<T> node, List<T> retList)
    {

	retList.add(node.data);
	if (node.left != null)
	{
	    preOrder(node.left, retList);
	}
	if (node.right != null)
	{
	    preOrder(node.right, retList);
	}

    }

    /**
     * Traverse Post-Order Left child, right child, Node
     * 
     * @param node
     *            - The node to be traversed
     * @param retList
     *            - The list in which the data is to be added
     */
    private static <T> void postOrder(Node<T> node, List<T> retList)
    {
	if (node.left != null)
	{
	    postOrder(node.left, retList);
	}
	if (node.right != null)
	{
	    postOrder(node.right, retList);
	}
	retList.add(node.data);
    }

    /**
     * Level-Order - the output should be such that all nodes at the same level should be output in sequence
     * 
     * @param node
     *            - The node to be traversed
     * @param retList
     *            - The list in which the data is to be added
     */
    private static <T> void levelOrder(Node<T> node, List<T> retList)
    {
	IQueue<Node<T>> queue = new Queue<Node<T>>();
	queue.enqueue(node);

	while(!queue.isEmpty())
	{
	    Node<T> element = queue.dequeue();
	    retList.add(element.data);
	    if (element.left != null)
	    {
		queue.enqueue(element.left);
	    }
	    if (element.right != null)
	    {
		queue.enqueue(element.right);
	    }
	    
	}
    }

}
