package com.ephipi.algo.ita1.threesum;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ephipi.algo.ita1.threesum.ThreeSum;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public abstract class AbstractThreeSumTest {

    @Test
    public void testCases(){
        int[] a = new int[]{10,9,-7,8,-1,-6,0,1,-10};
        Set<int[]> triplets = getImpl().getTriplets(a);
        Set<int[]> expectedSet = new HashSet<int[]>();
        expectedSet.add(new int[]{10,0,-10});
        expectedSet.add(new int[]{-7,8,-1});
        expectedSet.add(new int[]{-1,0,1});
        expectedSet.add(new int[]{9,1,-10});

        assertSetDifference("All triplets with 0 sum",getSets(expectedSet),getSets(triplets));
        
    }
    
    private void assertSetDifference(String m,Set<?> expected, Set<?> actual){
        if (!expected.equals(actual)){
            StringBuilder sb = new StringBuilder(m);
            
            SetView<?> expectedNotFound = Sets.difference(expected, actual);
            if (!expectedNotFound.isEmpty()){
                sb.append(" Expected, but not found "  + expectedNotFound);
            }
            SetView<?> actualNotExpected = Sets.difference(actual, expected);

            if (!actualNotExpected.isEmpty()){
                sb.append(" Actual, but not expected "  + actualNotExpected);
            }
            
            Assert.fail(sb.toString());
        }
    }
    
    
    private Set<Set<Integer>> getSets(Set<int[]> inSets){
        Set<Set<Integer>> outSets = new HashSet<Set<Integer>>();
        for(int[] elem:inSets){
            HashSet<Integer> inSet = new HashSet<>();
            for(int i:elem){
                inSet.add(i);
            }
            outSets.add(inSet);
        }
        return outSets;
    }
    
    protected abstract ThreeSum getImpl();
}
