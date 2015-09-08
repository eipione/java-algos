package com.ephipi.algo.ita1.uf.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double Z_STAT = 1.96;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    /**
     * perform T independent experiments on an N-by-N grid
     * 
     * @param N
     * @param T
     */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException(
                    "Both N and T should be positive");
        double[] probs = new double[T];
        int N2 = N * N;
        for (int i = 0; i < T; i++) {
            int count = countWhenSystemPercolates(N);
            probs[i] = (double) count / (double) N2;
        }

        this.mean = StdStats.mean(probs);
        this.stddev = StdStats.stddev(probs);
        this.confidenceLo = mean - Z_STAT * stddev / Math.sqrt(T);
        this.confidenceHi = mean + Z_STAT * stddev / Math.sqrt(T);
    }

    private int countWhenSystemPercolates(int N) {
        Percolation perc = new Percolation(N);
        int count = 0;
        while (!perc.percolates()) {
            int row = StdRandom.uniform(N) + 1;
            int column = StdRandom.uniform(N) + 1;
            if (!perc.isOpen(row, column)) {
                perc.open(row, column);
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * @return sample mean of percolation threshold
     */
    public double mean() {
        return mean;
    }

    /**
     * 
     * @return sample standard deviation of percolation threshold
     */
    public double stddev() {
        return stddev;
    }

    /**
     * 
     * @return low endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return confidenceLo;
    }

    /**
     * 
     * @return high endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return confidenceHi;
    }

    private static String padRight(String s, int resultLength) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length(); i < resultLength; i++) {
            sb.append(" ");
        }
        return sb.toString();

    }

    // test client (described below)
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int l = "95% confidence interval".length();
        PercolationStats stats = new PercolationStats(N, T);
        System.out.println(padRight("mean", l) + " = " + stats.mean());
        System.out.println(padRight("stddev", l) + " = " + stats.stddev());
        System.out.println(padRight("95% confidence interval", l) + " = "
                + stats.confidenceLo() + " , " + stats.confidenceHi());
    }

}