package com.ephipi.algo.ita1.uf.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int N;
    private final boolean[] openSites;
    private final WeightedQuickUnionUF uf;
    private final int virtualStartLoc;
    private final int virtualEndLoc;

    /**
     * create N-by-N grid, with all sites blocked
     * 
     * @param N - The n or NXN grid
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N Should be positive");
        }
        this.N = N;
        int size = (N + 1) * (N + 1);
        this.openSites = new boolean[size];
        this.uf = new WeightedQuickUnionUF(size);
        this.virtualStartLoc = location(0, 0);
        this.virtualEndLoc = location(N, 0);

    }

    /**
     * open site (row i, column j) if it is not
     * 
     * @param i
     * @param j
     */
    public void open(int i, int j) {
        checkIndices(i, j);
        int loc = location(i, j);
        if (openSites[loc]) {
            return;
        }

        openSites[loc] = true;
        connectIfOpen(i - 1, j, loc);
        connectIfOpen(i + 1, j, loc);
        connectIfOpen(i, j - 1, loc);
        connectIfOpen(i, j + 1, loc);

        // If we get a location in the top row then connect it to the virtual
        // start
        if (i == 1) {
            uf.union(virtualStartLoc, loc);
        }

        // If we get a location in the bottom row then connect it to virtual end
        if (i == N) {
            uf.union(virtualEndLoc, loc);
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
        return uf.connected(virtualStartLoc, virtualEndLoc);
    }

    
    private boolean isConnectedToTop(int i, int j) {
        return uf.connected(location(i, j), virtualStartLoc);
    }
    
    /**
     * Connect the site i,j with the one specified by the location loc
     * 
     * @param i
     * @param j
     * @param loc
     */
    private void connectIfOpen(int i, int j, int loc) {
        if (outSideBounds(i) || outSideBounds(j)) {
            // No Need to Connect
        } else {
            if (isOpen(i, j)) {
                uf.union(loc, location(i, j));
            }
        }
    }
    
    private void checkIndices(int i, int j) {
        if (outSideBounds(i)) {
            throw new IndexOutOfBoundsException("i should be <= " + N);
        }
        if (outSideBounds(j)) {
            throw new IndexOutOfBoundsException("j should be <= " + N);
        }

    }

    private boolean outSideBounds(int i) {
        return i < 1 || i > N;
    }


    private int location(int i, int j) {
        return (i * (N + 1)) + j;
    }


    // test client (optional)
    public static void main(String[] args) {

    }

}
