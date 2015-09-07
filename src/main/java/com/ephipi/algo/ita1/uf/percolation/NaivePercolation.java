package com.ephipi.algo.ita1.uf.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class NaivePercolation {
	
	private final int N;
	private final boolean[] openSites;
	private final WeightedQuickUnionUF uf;
	
	
	/**
	 * create N-by-N grid, with all sites blocked
	 * 
	 * @param N
	 */
	public NaivePercolation(int N) {
		this.N = N;
		int size = (N+1) * (N+1);
		this.openSites = new boolean[size];
		this.uf = new WeightedQuickUnionUF(size);
		
		
	}

	/**
	 * open site (row i, column j) if it is not
	 * 
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {
		checkIndices(i,j);
		int loc = location(i,j);
		if (openSites[loc]) return;
		
		openSites[loc] = true;
		connectIfOpen(i-1,j,loc);
		connectIfOpen(i+1,j,loc);
		connectIfOpen(i,j-1,loc);
		connectIfOpen(i,j+1,loc);
		
	}

	/**
	 * Connect the site i,j with the one specified by the location loc
	 * @param i
	 * @param j
	 * @param loc
	 */
	private void connectIfOpen(int i,int j, int loc){
		if ( (i < 1 || i >N) || (j < 1 || j > N)){
			// No Need to Connect
		} else {
			if (isOpen(i, j)){
				uf.union(loc, location(i,j));
			}
		}
	}

	

	/**
	 * 
	 * @param i
	 * @param j
	 * @return is site (row i, column j) open?
	 */
	public boolean isOpen(int i, int j) {
		return openSites[location(i, j)];
	}

	/**
	 * 
	 * @param i
	 * @param j
	 * @return is site (row i, column j) full?
	 */
	public boolean isFull(int i, int j) {
		return isOpen(i, j) && isConnectedToTop(i, j);
	}

	/**
	 * 
	 * @return // does the system percolate?
	 */
	public boolean percolates() {
		for(int c=1;c<=N;c++){
			if ( isOpen(N,c) && isConnectedToTop(N, c) ){
				return true;
			}
		}
		return false;
	}
	
	
	private void checkIndices(int i, int j) {
		if (i < 1 || i > N){
			throw new IndexOutOfBoundsException("i should be <= " + N);
		}
		if (j < 1 || j > N){
			throw new IndexOutOfBoundsException("j should be <= " + N);
		}
		
	}
	
	private int location(int i, int j) {
		return (i * (N+1) ) + j;
	}
	
	
	private boolean isConnectedToTop(int i, int j){
		int location = location(i,j);
		for(int c=1;c<=N;c++){
			if (isOpen(1,c) && uf.connected(location, location(1,c))){
				return true;
			}
		}
		return false;
	}

	// test client (optional)
	public static void main(String[] args) {

	}
	
	
}
