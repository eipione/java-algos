

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContiguousSumProblemSolverTest {

	private ContiguousSumProblemSolver solver;

	@Before
	public void setUp() {
		solver = new ContiguousSumProblemSolver();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		int[] empty = new int[0];
		solver.getMaxSum(empty);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		int[] nullA = new int[0];
		solver.getMaxSum(nullA);
	}

	@Test
	public void testSimple() {
		int[] input = new int[] { 3 };
		int result = solver.getMaxSum(input);
		Assert.assertEquals("Result did not match for simple input", 3, result);
	}

	@Test
	public void testAllPositive() {
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		int result = solver.getMaxSum(input);
		Assert.assertEquals("Result did not match for all positive input", 15,
				result);
	}

	@Test
	public void testAllNegative() {
		int[] input = new int[] { -4, -2, -3, -1, -5 };
		int result = solver.getMaxSum(input);
		Assert.assertEquals("Result did not match for all negative input", -1,
				result);
	}

	@Test
	public void testZeroStart() {
		int[] input = new int[] { 0, 1, 2, -1, 4, 10, -9 };
		int result = solver.getMaxSum(input);
		Assert.assertEquals("Result did not match for zero start input", 16,
				result);

	}

	@Test
	public void testMixed() {
		int[] input = new int[] { -11, 4, 6, -18, 9, -8 };
		int result = solver.getMaxSum(input);
		Assert.assertEquals("Result did not match for mixed input", 10, result);

	}

	@Test
	public void Test2Algos() {
		int[] input = randomIntArray(1000, 10000);
		int resultOld = solver.getMaxSumOld(input);
		int resultNew = solver.getMaxSum(input);

		Assert.assertEquals("Result of 2 algos did not match", resultOld,
				resultNew);
	}

	private int[] randomIntArray(int size, int range) {
		int[] randomArray = new int[size];

		Random random = new Random();
		for (int i = 0; i < size; i++) {
			randomArray[i] = (random.nextBoolean() ? 1 : -1)
					* random.nextInt(range);
		}

		return randomArray;
	}

}