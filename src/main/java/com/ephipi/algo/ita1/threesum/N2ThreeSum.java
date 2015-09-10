package com.ephipi.algo.ita1.threesum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// Hint: given an integer x and a sorted array a[] of N distinct integers, design a linear-time algorithm 
// to determine if there exists two distinct indices i and j such that a[i] + a[j] == x.


public class N2ThreeSum implements ThreeSum{

    @Override
    public Set<int[]> getTriplets(int [] a){
        Arrays.sort(a);
        Set<int[]> retSet = new HashSet<>();
        for(int i=0;i<a.length;i++){
            int start = i+1;
            int end = a.length - 1;
            while (start < end){
                int sum = a[i] + a[start] + a[end];
                if (sum == 0){
                    retSet.add(new int[]{a[i],a[start],a[end]});
                    start++;
                    end--;
                } else if (sum > 0){
                    end--;
                } else if (sum < 0 ){
                    start++;
                }
            }
            
        }
        return retSet;
    }
}
