package com.ephipi.algo.ita1.uf;


public class WeightedQuickUnion implements UnionFind {

	final int[] ids;
	private final int[] sizes;
	boolean pathCompression = true;

	public WeightedQuickUnion(int n) {
		this.ids = new int[n];
		this.sizes = new int[n];
		for (int i = 0; i < n; i++) {
			ids[i] = i;
			sizes[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		// q's root becomes the parent of p
		int rootOfPtree = root(p);
		int rootOfQTree = root(q);
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
		setSize(parent, getSize(parent) + getSize(child));
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	public int find(int p) {
		return root(p);
	}

	@Override
	public int count() {
		return ids.length;
	}

	private void flatten(int p, int root) {
		while (getParent(p) != root) {
			int next = getParent(p);
			setParent(p, root);
			p = next;
		}
	}

	int heightToRoot(int p) {
		int count = 1;
		while (ids[p] != p) {
			p = ids[p];
			count++;
		}

		return count;
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

	private void setParent(int child, int parent) {
		ids[child] = parent;
	}

	int getSize(int p) {
		return sizes[p];
	}

	void setSize(int p, int newSize) {
		sizes[p] = newSize;
	}

	

}
