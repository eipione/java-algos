package com.ephipi.algo.ita1.uf;

public class QuickFind implements UnionFind{

	private final int[] nodes;
	
	public QuickFind(int n){
		this.nodes = new int[n];
		for(int i=0;i<n;i++){
			nodes[i] = i;
		}
	}
	
	@Override
	public void union(int p, int q) {
		int pid = nodes[p];
		int qid = nodes[q];
		
		for(int i=0;i< nodes.length;i++){
			if (nodes[i]  == qid){
				nodes[i] = pid;
			}
		}
				
	}

	@Override
	public boolean connected(int p, int q) {
		return nodes[p] == nodes[q];
	}

	@Override
	public int find(int p) {
		return nodes[p];
	}

	@Override
	public int count() {
		return nodes.length;
	}

}
