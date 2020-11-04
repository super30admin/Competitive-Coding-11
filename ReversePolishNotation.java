/*
*
*   Types of mathematical notations:
*       1. Prefix -> + 3 4, operator before operands
*       2. Infix -> 3 + 4, operator in between operands
*       3. Postfix -> 3 4 +, operator after operands
*
*       Prefix notation is the Polish Notation
*       Reverse Prefix notation, we get Postfix notation
*       So, Postfix notation is the Reverse Polish Notation where operands are given before operator, we have to evaluate the RPN(Postfix notation) and return the result
*
*/

/*
 * #150. Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

 */


/*
*
*   Time Complexity: O (N) -> To traverse 'N' elements of "tokens" string array
*
*   Space Complexity: O (D) -> Stack to store the 'D' digits(operands) in "tokens" array
*
*   Did this code successfully run on leetcode: Yes
* 
*   Any problem you faced while coding this: No
*
*/

package com.s30.edu.competitivecoding11;

import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
        
        // #1. Base condition
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        
        // #2. Create a stack to store the operands
        Stack<Integer> stack = new Stack<>();
        
        // #3. Traverse thorugh the "tokens" array
        // Traverse the array elements-> O (N) operation
        for(int i = 0; i < tokens.length; i++){
            
            // #3.1. Get the current string/element from "tokens" array
            String currChar = tokens[i];
            
            // #3.2. If current characater is a digit, convert char to integer and push to stack
            if(!"+-*/".contains(currChar)){
                stack.push(Integer.valueOf(currChar)); // push() -> O (1)
                // If continue statement is not added, then after pushing one operand in stack, the next lines of code will try to pop two operands from stack and throw StackEmptyException
                continue; // continue statement will skip the next lines of code until operands are pushed to stack before encountering an operator
            }
            
            // #3.3 If current character is an operator, pop the operands from stack, evaluate the result and push the result back to stack
            
            
            // #3.3.1. Pop the operands from stack when an operator is encountered
            // pop() -> O (1) operation
            int number2 = stack.pop();
            int number1 = stack.pop();
            
            // #3.3.2. Initialize the result to 0
            int result = 0;
            
            // #3.3.3. Switch case
            // Evaluate the result once operator is encountered -> O (1) operation
            switch(currChar){
                case "+":
                    result = number1 + number2;
                    break;
                
                case "-": 
                    result = number1 - number2;
                    break;
                    
                case "*": 
                    result = number1 * number2;
                    break;
                    
                case "/": 
                    result = number1 / number2;
                    break;
                    
            }
            
            stack.push(result); // O (1) operation
        }
        
        // #4. Return the final result of RPN(Reverse Polish Notation) expression evaluation
        return stack.pop(); // O (1) operation
        
    }

}
