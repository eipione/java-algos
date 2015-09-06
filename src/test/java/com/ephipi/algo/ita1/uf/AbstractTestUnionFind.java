package com.ephipi.algo.ita1.uf;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractTestUnionFind {

	protected static final int N = 10;

	public AbstractTestUnionFind() {
		super();
	}

	@Test
	public void testCount() {
		Assert.assertEquals("The count equal to number of nodes",N, getUF().count());
	}

	
	@Test
	public void testAllComponentsSeparateWhenInitialized() {
		UnionFind uf = getUF();
		Set<Integer> components = new HashSet<>();
		for(int i=0;i<N;i++){
			components.add(uf.find(i));
		}
		
		Assert.assertEquals("The number of distinct components should be the number of nodes",N, components.size());

	}

	
	@Test
	public void testFindNoConnections() {
		UnionFind uf = getUF();

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if (i != j){
					Assert.assertFalse("Components should not be connected " + i +"," + j,uf.connected(i, j));
				}
			}
		}
	}

	@Test
	public void testFindAllConnected() {
		UnionFind uf = getUF();
		
		for(int i=1;i<N;i++){
			uf.union(i-1, i);
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if (i != j){
					Assert.assertTrue("All Components should be connected "+ i +"," + j,uf.connected(i, j));
				}
			}
		}
	}
	
	
	@Test
	public void testFindAllOddsConnected() {
		UnionFind uf = getUF();
		
		uf.union(1, 5);
		uf.union(3, 9);
		uf.union(7, 5);
		uf.union(1, 9);

		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if (i != j){
					if (i % 2 == 1 && j %2 ==1){
						Assert.assertTrue("All Odd Components should be connected "+ i +"," + j,uf.connected(i, j));
					} else {
						Assert.assertFalse("All Non-Odd Components should be not connected "+ i +"," + j,uf.connected(i, j));
					}
				}
			}
		}
		
		
		int component = uf.find(1);
		
		for(int i=1;i<N;i+=2){
			Assert.assertEquals("All odss should have same component number " + i,component, uf.find(1));
		}
	}
	
	protected abstract UnionFind getUF();


}