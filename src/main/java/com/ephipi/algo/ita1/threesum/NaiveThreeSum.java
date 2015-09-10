package com.ephipi.algo.ita1.threesum;

import java.util.HashSet;
import java.util.Set;

public class NaiveThreeSum implements ThreeSum{

    @Override
    public Set<int[]> getTriplets(int [] a){
        Set<int[]> retSet = new HashSet<>();
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                for(int k=j+1;k<a.length;k++){
                    if (a[i] + a[j] + a[k] == 0){
                        retSet.add(new int[]{a[i],a[j],a[k]});
                    }
                }
            }
        }
        return retSet;
    }
}
