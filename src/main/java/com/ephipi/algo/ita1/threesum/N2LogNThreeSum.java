package com.ephipi.algo.ita1.threesum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N2LogNThreeSum implements ThreeSum{

    @Override
    public Set<int[]> getTriplets(int [] a){
        Arrays.sort(a);
        Set<int[]> retSet = new HashSet<>();
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                Integer thirdPart = - (a[i] + a[j]);
                if (Arrays.binarySearch(a, thirdPart) >= 0){
                    retSet.add(new int[]{a[i],a[j],thirdPart});
                }
            }
        }
        return retSet;
    }
}
