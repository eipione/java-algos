package com.ephipi.java.algo.strings;

public class StringRotation
{

    
    /**
     * Returns true if the second string can be obtained by a rotation of 
     * the first string (or vice versa)
     * @param s1 - The first String
     * @param s2 - The second String
     * @return
     */
    public static boolean isRotationOf(String s1,String s2)
    {
	// If both are null return true
	if (s1 == null && s2 == null) return true;
	
	// If only 1 is null return false
	if (s1 == null || s2 == null) return false;
	
	// If length is unequal return false
	if (s1.length()!= s2.length()) return false;
	
	// If both are empty return true
	if (s1.length() == 0 && s2.length() == 0) return true;
	
	for(int i=0;i<s1.length();i++)
	{
	    int pos = 0;
	    char c1 = 0;
	    char c2 = 0;
	    do
	    {
		 c1 = s1.charAt((i+pos) % s1.length());
		 c2 = s2.charAt(pos);
		 pos++;
	    }
	    while((c1 == c2) && pos < s1.length());
	    
	    if (pos == s1.length() && (c1==c2)) return true;
  
	}
	
	return false;
    }
    
    
}
