package com.ephipi.algo.ita1.uf;

import java.util.Arrays;

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
			if (nodes[i]  == pid){
				nodes[i] = qid;
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
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		String s= "5-3 9-2 9-5 5-1 0-2 1-4";
		
		
		String[] sp = s.split(" ");
		for(String sp1:sp){
			String[] c = sp1.split("-");
			qf.union(Integer.parseInt(c[0]),Integer.parseInt(c[1]));
		}
		
	
		
		System.out.println(Arrays.toString(qf.nodes).replace(",", ""));
	}

}
