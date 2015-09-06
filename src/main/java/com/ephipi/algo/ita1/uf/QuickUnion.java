package com.ephipi.algo.ita1.uf;

public class QuickUnion implements UnionFind{

	private final int[] nodes;
	
	public QuickUnion(int n){
		this.nodes = new int[n];
		for(int i=0;i<n;i++){
			nodes[i] = i;
		}
	}
	
	@Override
	public void union(int p, int q) {
		// p's root becomes a child of q
		nodes[root(p)] = root(q);
				
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	int root(int p){
		while(nodes[p] != p){
			p = nodes[p];
		}
		return p;
	}
	
	int parent(int p){
		return nodes[p];
	}

	@Override
	public int find(int p) {
		return root(p);
	}

	@Override
	public int count() {
		return nodes.length;
	}

}
