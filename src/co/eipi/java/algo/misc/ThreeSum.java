package co.eipi.java.algo.misc;

public class ThreeSum
{

    public static int countZeroSumsBrute(int[] a)
    {
	int count = 0;
	
	for (int i = 0; i < a.length; i++)
	{
	    for (int j = i+1; j < a.length; j++)
	    {
		for (int k=j+1;k<a.length;k++)
		{
		    int sum = a[i] + a[j] + a[k];
		    if (sum == 0) count++;
		}
	    }
	}
	
	return count;
    }
    
    public static void main(String args[])
    {
	int[] a = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
	System.out.println(countZeroSumsBrute(a));
    }

}
