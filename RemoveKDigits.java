/*
 * #402. Remove K Digits
 * 
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */


/*
 *  Time Complexity: O (N) -> To traverse the input string "num"
 * 
 *  Space Complexity: O (N) -> Stack to store the chaacters in a string 
 * 
 *  Did this code successfully run on leetcode: Yes
 * 
 *  Any problem you faced while coding this: No
 *  
 */
package com.s30.edu.competitivecoding11;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        
        // Create a stack
        Stack<Character> stack = new Stack<>();
        
        StringBuilder output = new StringBuilder(); 
        
        // Traverse throught the string
        for(int i = 0; i < num.length(); i++){
            
            char ch = num.charAt(i);
            
            while(!stack.isEmpty() && k > 0 && stack.peek() > ch){
                stack.pop();
                    k--;
            }
            
            // skip the leading zeroes, if stack is empty and character is '0'(leading zero), don't push to stack
            if(!stack.isEmpty() || ch != '0'){
                stack.push(ch);
            }
            
        }
        
        // Takes care of the edge cases
        /*
        *   1. e.g: num = ["123"], k = 2
        *       In this case, everything will be pushed to stack and nothing is removed, and after exiting for loop, k will be still 2
        *   2. e.g: num = ["9"], k = 1, where k = num.length()
        */
        // 1st edge case -> pop(remove) k digits from the stack
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        
        // 2nd edge case -> When number of digits to remove from string "k" is equal to length of string "num"
        // All digits are removed from the string -> ""
        if(stack.isEmpty()){
            return "0"; 
        }
        
        // pop from the stack and append to output string
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }
        
        // Reverse the output string 
        output = output.reverse();
        
        return output.toString(); // return minimum possible number after removing 'k' digits from string
        
    }

}
