package com.ephipi.algo.ita1.uf;

import org.junit.Assert;
import org.junit.Test;


public class WeightedQuickUnionTest extends AbstractTestUnionFind{

	@Override
	protected WeightedQuickUnion getUF() {
		return new WeightedQuickUnion(N);
	}
	
	
	@Test
	public void testRootAndParent(){
		WeightedQuickUnion uf = getUF();
		uf.union(1, 2);
		uf.union(2, 5);
		
		Assert.assertEquals("Root of 2",1,uf.root(2));
		Assert.assertEquals("Root of 1",1,uf.root(1));
		Assert.assertEquals("Root of 5",1, uf.root(5));
	}
	
	
}
