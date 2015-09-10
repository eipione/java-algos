package com.ephipi.algo.ita1.threesum;

import com.ephipi.algo.ita1.threesum.NaiveThreeSum;
import com.ephipi.algo.ita1.threesum.ThreeSum;


public class NaiveThreeSumTest extends AbstractThreeSumTest{

    @Override
    protected ThreeSum getImpl() {
       return new NaiveThreeSum();
    }

    
}
