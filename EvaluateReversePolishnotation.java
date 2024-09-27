package competitiveCoding11;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishnotation {
	//Time Complexity : O(n), where n is the length of tokens array
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int evalRPN(String[] tokens) {
        // null
        if(tokens == null || tokens.length == 0)
            return 0;
        
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        
        for(int i=0; i<tokens.length; i++) {
            if(operators.contains(tokens[i])) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                
                if(tokens[i].equals("+"))
                    res = num2 + num1;
                if(tokens[i].equals("-"))
                    res = num2 - num1;
                if(tokens[i].equals("*"))
                    res = num2 * num1;
                if(tokens[i].equals("/"))
                    res = num2 / num1;
                stack.push(String.valueOf(res));
            } else {
                stack.push(tokens[i]);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}
