package com.ephipi.algo.ita1.uf;

import java.util.Arrays;

public class WQUAssgn {
	public static void main(String[] args) {
		checkFinalPositions();
		 checkValidTree();

	}

	private static void checkValidTree() {
		WeightedQuickUnion qf = new WeightedQuickUnion(10);
		String[] inStrings = new String[] { 
				"2 8 8 2 2 4 8 8 8 6",
				 
				"7 1 8 1 2 1 5 7 5 3", 
				 
				"4 6 9 9 4 6 9 4 3 4", 
				 
//				"5 7 1 1 1 1 1 0 5 1" ,
				 
				"2 1 2 1 2 5 6 7 8 9"    };
		for (String inString : inStrings) {
			System.out.println(inString);
			if (getHeightsToRoot(qf, inString)){
				System.out.println("Tree's heights valid");
			} else {
				System.out.println("Tree's heights invalid");
			}
			System.out.println("*****************************");
		}
	}

	private static boolean getHeightsToRoot(WeightedQuickUnion qf, String inString) {
		String[] nos = inString.split(" ");
		int count = 0;
		for (String no : nos) {
			qf.ids[count++] = Integer.parseInt(no);
		}
		
	

		for (int i = 0; i < 10; i++) {
			int heightToRoot = qf.heightToRoot(i);
			if (heightToRoot > 4){
				return false;
			}
		}
		
		
		
		return true;
	}

	private static void checkFinalPositions() {
		WeightedQuickUnion qf = new WeightedQuickUnion(10);
		qf.pathCompression = false;

		// 4-9 3-1 7-6 5-1 4-3 8-0 7-8 6-3 4-2
		
		String s = "7-2 3-8 9-5 7-8 1-9 6-1 0-9 2-1 0-4";
		String[] sp = s.split(" ");
		for(String sp1:sp){
			String[] c = sp1.split("-");
			qf.union(Integer.parseInt(c[0]),Integer.parseInt(c[1]));
		}
		
	
		System.out.println(Arrays.toString(qf.ids).replace(",", ""));
	}
}
