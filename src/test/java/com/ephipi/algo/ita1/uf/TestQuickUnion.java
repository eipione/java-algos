package com.ephipi.algo.ita1.uf;

import org.junit.Assert;
import org.junit.Test;



public class TestQuickUnion extends AbstractTestUnionFind {

	@Override
	protected QuickUnion getUF() {
		return new QuickUnion(N);
	}
	
	@Test
	public void testRootAndParent(){
		QuickUnion uf = getUF();
		uf.union(1, 2);
		uf.union(2, 5);
		
		Assert.assertEquals("Root of 2",uf.root(2),5);
		Assert.assertEquals("Root of 1",uf.root(2),5);
		Assert.assertEquals("Root of 5",uf.root(2),5);

	}
	
	
}
