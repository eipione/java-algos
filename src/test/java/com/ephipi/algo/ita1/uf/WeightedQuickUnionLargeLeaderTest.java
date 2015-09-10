package com.ephipi.algo.ita1.uf;

import org.junit.Assert;
import org.junit.Test;

public class WeightedQuickUnionLargeLeaderTest extends AbstractTestUnionFind {

    @Override
    protected WeightedQuickUnionLargeLeader getUF() {
        return new WeightedQuickUnionLargeLeader(N);
    }

   

    @Test
    public void testFindLargest() {
        UnionFind uf = getUF();

        uf.union(1, 5);
        uf.union(3, 9);
        uf.union(7, 5);
        uf.union(1, 9);
        
        uf.union(2, 4);
        uf.union(4, 6);
        uf.union(6, 8);
        uf.union(0, 6);
        
        for(int i=1;i<N;i+=2){
           Assert.assertEquals("Leader for " + i ,9, uf.find(i));
        }
        
        for(int i=0;i<N;i+=2){
            Assert.assertEquals("Leader for " + i ,8, uf.find(i));
         }

    }
}
