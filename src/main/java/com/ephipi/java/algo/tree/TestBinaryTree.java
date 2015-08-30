package com.ephipi.java.algo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.java.algo.tree.BinaryTree.Node;
import com.ephipi.java.algo.tree.BinaryTreeTraverse.Order;

public class TestBinaryTree
{

    private List<Node<Integer>> getNodes(int n)
    {
	List<Node<Integer>> list = new ArrayList<Node<Integer>>();

	for (int i = 0; i < n; i++)
	{
	    list.add(new Node<Integer>(i));
	}

	return list;
    }

    @Test
    public void testInOrder()
    {
	List<Node<Integer>> list = getNodes(10);

	BinaryTree<Integer> tree = new BinaryTree<Integer>(list.get(5));

	tree.root.left = list.get(3);
	list.get(3).left = list.get(2);
	list.get(3).right = list.get(4);

	list.get(2).left = list.get(1);

	tree.root.right = list.get(7);

	list.get(7).right = list.get(8);
	list.get(7).left = list.get(6);
	list.get(8).right = list.get(9);

	List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	Assert.assertEquals(expectedList,
		BinaryTreeTraverse.order(tree, Order.IN_ORDER));

    }

    @Test
    public void testPreOrder()
    {
	List<Node<Integer>> list = getNodes(10);

	BinaryTree<Integer> tree = new BinaryTree<Integer>(list.get(1));

	tree.root.left = list.get(2);

	tree.root.right = list.get(6);

	list.get(2).left = list.get(3);
	list.get(2).right = list.get(4);
	list.get(4).left = list.get(5);

	list.get(6).left = list.get(7);
	list.get(6).right = list.get(8);

	list.get(8).right = list.get(9);

	List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	Assert.assertEquals(expectedList,
		BinaryTreeTraverse.order(tree, Order.PRE_ORDER));

    }

    @Test
    public void testPostOrder()
    {
	List<Node<Integer>> list = getNodes(11);

	BinaryTree<Integer> tree = new BinaryTree<Integer>(list.get(10));

	tree.root.left = list.get(5);

	tree.root.right = list.get(9);

	list.get(5).left = list.get(2);
	list.get(5).right = list.get(4);

	list.get(2).left = list.get(1);
	list.get(4).left = list.get(3);

	list.get(9).left = list.get(7);
	list.get(7).left = list.get(6);

	list.get(9).right = list.get(8);

	List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,
		10);

	Assert.assertEquals(expectedList,
		BinaryTreeTraverse.order(tree, Order.POST_ORDER));

    }

    @Test
    public void testLevelOrder()
    {
	List<Node<Integer>> list = getNodes(13);

	BinaryTree<Integer> tree = new BinaryTree<Integer>(list.get(1));

	list.get(1).left = list.get(2);
	list.get(1).right = list.get(3);

	list.get(2).left = list.get(4);
	list.get(2).right = list.get(5);

	list.get(3).left = list.get(6);
	list.get(3).right = list.get(7);

	list.get(4).left = list.get(8);
	list.get(4).right = list.get(9);
	
	list.get(6).left = list.get(10);
	list.get(7).right = list.get(11);
	
	list.get(8).left = list.get(12);

	List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12);

	Assert.assertEquals(expectedList,
		BinaryTreeTraverse.order(tree, Order.LEVEL_ORDER));

    }
}
