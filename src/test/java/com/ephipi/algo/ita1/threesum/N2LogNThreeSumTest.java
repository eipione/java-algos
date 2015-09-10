package com.ephipi.algo.ita1.threesum;

import com.ephipi.algo.ita1.threesum.N2LogNThreeSum;
import com.ephipi.algo.ita1.threesum.ThreeSum;


public class N2LogNThreeSumTest extends AbstractThreeSumTest{

    @Override
    protected ThreeSum getImpl() {
       return new N2LogNThreeSum();
    }

    
}
