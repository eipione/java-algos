

/**
 * Problem Given the input: int[] input = { -11, 4, 6, -18, 9, -8 };
 * 
 * Determine the largest contiguous sum.
 * 
 * The expected output should be: 10
 * 
 * 
 * NOTE: If the input is null or empty, throw an IllegalArgumentException. That
 * tells the user "Must have a valid input"
 */

public class ContiguousSumProblemSolver {

	
	// Calculate max sum in O(n^2) time
	public int getMaxSumOld(int[] input) {
		if (input == null || input.length == 0)
			throw new IllegalArgumentException("Must have a valid input");

		
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0;i<input.length;i++)
		{
			int sumStartingAtI = getMaxSum(input,i);
			if (sumStartingAtI > maxSum)
				maxSum = sumStartingAtI;
		}
		
		return maxSum;

	}
	
	// Calculate max sum in O(n) time
	public int getMaxSum(int[] input) {
		if (input == null || input.length == 0)
			throw new IllegalArgumentException("Must have a valid input");
		
		int runningSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0;i<input.length;i++)
		{
			
			// If the runningSum till here is negative then set a new starting point
			// otherwise use the older starting point
			runningSum = runningSum < 0 ? input[i] : runningSum + input[i];
			
			if (runningSum > maxSum)
				maxSum = runningSum;
			
		}

		return maxSum;

	}
	
	
	private int getMaxSum(int[] input, int start)
	{
		if (start < 0 || start > input.length -1) 
			throw new IllegalArgumentException("start should be between 0 and "+ input.length);
		
		int maxSum = Integer.MIN_VALUE;
		int runningSum = 0;
		
		for(int i=start;i<input.length;i++)
		{
			runningSum+=input[i];
			if (runningSum > maxSum)
			{
				maxSum = runningSum;
			}
		}
		
		return maxSum;
	}
	
	
	

}
