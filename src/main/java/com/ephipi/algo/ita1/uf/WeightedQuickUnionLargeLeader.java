package com.ephipi.algo.ita1.uf;


public class WeightedQuickUnionLargeLeader implements UnionFind {

	private final int[] ids;
	private final int[] sizes;
	private final int[] largest;
	boolean pathCompression = true;
	private int count;

	public WeightedQuickUnionLargeLeader(int n) {
		this.ids = new int[n];
		this.sizes = new int[n];
		this.largest = new int[n];
		for (int i = 0; i < n; i++) {
			ids[i] = i;
			sizes[i] = 1;
			largest[i] = i;
		}
		this.count = n;
	}

	@Override
	public void union(int p, int q) {
		int rootOfPtree = root(p);
		int rootOfQTree = root(q);
		
	    if (rootOfPtree == rootOfQTree) return;
	    
		int parent;
		int child;
		if (getSize(rootOfPtree) >= getSize(rootOfQTree)) {
			parent = rootOfPtree;
			child = rootOfQTree;
		} else {
			parent = rootOfQTree;
			child = rootOfPtree;
		}

		setParent(child, parent);
		setMax(parent, Math.max(getMax(parent), getMax(child)));
		setSize(parent, getSize(parent) + getSize(child));
		count--;
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	public int find(int p) {
		return largest[root(p)];
	}

	@Override
	public int count() {
		return count;
	}

	private void flatten(int p, int root) {
		while (getParent(p) != root) {
			int next = getParent(p);
			setParent(p, root);
			p = next;
		}
	}

	int heightToRoot(int p) {
		int ht = 1;
		while (ids[p] != p) {
			p = ids[p];
			ht++;
		}

		return ht;
	}

	int root(int p) {
		int loc = p;
		while (ids[p] != p) {
			p = ids[p];
		}
		if (pathCompression) {
			flatten(loc, p);
		}
		return p;
	}

	int getParent(int child) {
		return ids[child];
	}
	
	int getMax(int location) {
        return largest[location];
    }

	private void setParent(int child, int parent) {
		ids[child] = parent;
	}
	
	private void setMax(int location, int max) {
        largest[location] = max;
    }

	int getSize(int p) {
		return sizes[p];
	}

	void setSize(int p, int newSize) {
		sizes[p] = newSize;
	}

	

}
