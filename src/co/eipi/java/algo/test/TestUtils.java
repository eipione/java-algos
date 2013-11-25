package co.eipi.java.algo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUtils
{
    
    /**
     * Create a random integer list of size = size and values 
     * from 0(inclusive) to max(exclusive)
     * @param size
     * @param max
     * @return
     */
    public static List<Integer> genRandomList(int size,int max)
    {
	// Specify the size since in this case we know it
	List<Integer> retList = new ArrayList<Integer>(size);
	Random random = new Random();
	for (int i=0;i<size;i++)
	{
	    retList.add(random.nextInt(max));
	}
	
	return retList;
    }
    
    /**
     * Generates a random string array with length up to maxLength
     * @param size - the size of the list
     * @param maxLength - the maximum length of the string
     * @return
     */
    public static List<String> genRandomStringList(int size,int maxLength)
    {
	List<String> retList = new ArrayList<String>(size);
	Random random = new Random();
	for (int i=0;i<size;i++)
	{
	    retList.add(RandomStringUtils.randomAlphabetic(random.nextInt(maxLength)));
	}
		
	return retList;
    }
    
    public static String rotateString(String in)
    {
	if (in.length() == 0) return in;
	Random random = new Random();
	int randomStart = random.nextInt(in.length());
	char[] chars = new char[in.length()];
	
	for(int i=randomStart;i<randomStart+in.length();i++)
	{
	    chars[i-randomStart] = in.charAt(i%in.length());
	}
	
	return new String(chars);
    }
}
