package CompetitiveCoding_Dec27;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class EvaluateReversePolishNotation {
	
    public int evalRPN(String[] tokens) {
        
        /*
        Time complexity: O(n) where n is length of tokens string
        Space complexity: O(1) because though an additional stack and set is used in the solution, stack will have only 2 elements at any point of time. Set is of fixed size. i.e.4 for each of the operators.
        
        Approach used:
        Stack
        */
        
        // edge
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        
        Stack<String> st = new Stack<>();
        int res = 0;
        
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        
        for (int i = 0; i < tokens.length; i++) {
            String curStr = tokens[i];
            // incoming string element is an operation like +,-,*,/
            if (ops.contains(curStr)) {
                // pop out the two operands from the stack (will be top two elements of stack) on which current operation is to be performed
                int op1 = Integer.parseInt(st.pop());
                int op2 = Integer.parseInt(st.pop());
                if (curStr.equals("+")) {
                    res = op1 + op2;
                } else if (curStr.equals("-")) {
                    res = op2 - op1;
                } else if (curStr.equals("*")) {
                    res = op1 * op2;
                } else {
                    res = op2 / op1;
                } 
                st.push(res + "");
            } 
            // incoming string element is a number
            else {
                st.push(curStr);
            }
        }
        
        return res;
    }
}
