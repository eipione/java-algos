package co.eipi.java.algo.stack;

import java.util.HashSet;
import java.util.Set;

public class ExpressionEval
{

    private static enum Type
    {
	OPERATOR,
	OPERAND,
	LEFT_PARANTHESIS,
	RIGHT_PARATHESIS
    }
    
    private static Set<String> operators = new HashSet<String>();
    
    static
    {
	operators.add("+");
	operators.add("-");
    }
    
    
    public static int eval(String[] eval)
    {
	
	Stack<Integer> valueStack = new Stack<Integer>();
	Stack<String> operators = new Stack<String>();
	
	for(String s:eval)
	{
	    
	}
	
	return 0;
    }
    
    
    private static Type getType(String s)
    {
	if (s.equals("("))
	    return Type.LEFT_PARANTHESIS;
	
	return null;
    }
}
