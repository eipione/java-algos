package com.ephipi.java.algo.search;

import java.util.Arrays;

import com.ephipi.java.algo.test.TestUtils;

public class QuickSort {

	public static void main(String args[]) {
		int[] input = TestUtils.genRandomArray(100, 1000);
		int[] inputCopy = new int[input.length];
		System.arraycopy(input, 0, inputCopy, 0, input.length);

		sort(input);

		Arrays.sort(inputCopy);

		System.out.println(TestUtils.compare(input, inputCopy));

	}

	private static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int pivot = partition(a, lo, hi);
		sort(a, lo, pivot - 1);
		sort(a, pivot + 1, hi);

	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		while (true) {
			while (a[++i] < a[lo]) {
				if (i == hi)
					break;
			}

			while (a[lo] < a[--j]) {
				if (j == lo)
					break;
			}

			if (i >= j)
				break;

			swap(a, i, j);

		}

		swap(a, lo, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
