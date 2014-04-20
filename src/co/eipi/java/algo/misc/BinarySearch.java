package co.eipi.java.algo.misc;

import java.util.Arrays;
import java.util.Random;

import co.eipi.java.algo.test.TestUtils;

public class BinarySearch
{

    public static int binSearch(int key, int[] a)
    {
	int lo = 0;
	int hi = a.length - 1;
	while (lo <= hi)
	{
	    int mid = (hi + lo) / 2;
	    if (key < a[mid])
		hi = mid - 1;
	    else if (key > a[mid])
		lo = mid + 1;
	    else
		return mid;
	}
	System.out.println(hi);
	return lo;
    }

    public static void runTest1()
    {
	int[] randomArray = new int[]{1,4,6,7,10,34,89,500,629};

	int key = 67;

	int loc = binSearch(key, randomArray);

	int loc1 = Arrays.binarySearch(randomArray, key);

	System.out.println(loc + " " + loc1);
    }

    public static void runTest2()
    {
	int[] randomArray = TestUtils.genRandomArray(100, 200);
	Arrays.sort(randomArray);

	int key = new Random().nextInt(200);

	int loc = binSearch(key, randomArray);

	int loc1 = Arrays.binarySearch(randomArray, key);

	System.out.println(loc + " " + loc1);
    }
    
    public static void main(String args[])
    {
	runTest1();
	//runTest2();
    }
}
