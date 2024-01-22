package EvaluateReversePolishNotation;

import java.util.*;
import java.util.function.*;

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
* Using Stack, and functional programming (lambda)
*
*/

class Solution {
	
	private static final HashMap<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
	
	static {
		OPERATIONS.put("+", (a,b) -> a+b);
		OPERATIONS.put("-", (a,b) -> a-b);
		OPERATIONS.put("*", (a,b) -> a*b);
		OPERATIONS.put("/", (a,b) -> a/b);
	}
	
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        
        for(String el: tokens) {
            if(!OPERATIONS.containsKey(el)) {
                st.push(Integer.parseInt(el));
            }
            else {
                int second = st.pop();
                int first = st.pop();
                BiFunction<Integer, Integer, Integer> operator = OPERATIONS.get(el);
                int value = operator.apply(first, second);
                st.push(value);
            }
        }
        
        return st.pop();
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)

/**
* Using Stack
*
*/

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(String el: tokens) {
            if(!set.contains(el)) {
                st.push(Integer.parseInt(el));
            }
            else {
                int second = st.pop();
                int first = st.pop();
                
                if(el.equals("+")) {
                    int result = first + second;
                    st.push(result);
                }
                else if(el.equals("-")) {
                    int result = first - second;
                    st.push(result);                    
                }
                else if(el.equals("*")) {
                    int result = first * second;
                    st.push(result);                    
                }
                else if(el.equals("/")) {
                    int result = first / second;
                    st.push(result);                    
                }
                
            }
        }
        
        return st.pop();
    }
}