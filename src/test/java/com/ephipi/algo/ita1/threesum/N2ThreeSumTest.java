package com.ephipi.algo.ita1.threesum;

import com.ephipi.algo.ita1.threesum.N2ThreeSum;
import com.ephipi.algo.ita1.threesum.ThreeSum;


public class N2ThreeSumTest extends AbstractThreeSumTest{

    @Override
    protected ThreeSum getImpl() {
       return new N2ThreeSum();
    }

    
}
