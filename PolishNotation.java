//Time Complexity : O(n)
// Space Complexity : O(operands)  stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Remembering Regular Expression Syntax in Java is difficult, but cant forget syntax in interviews.
/* Your code here along with comments explaining your approach: As you get operands, push them into the stack. if an operator arrives, check if its 
an operator using the regular expression, and do the corresponding operation to store the result in res. Elsewise, store the integer operand in the
res and push it into the stack in either cases. When operator arrives, pop two operands for the operator, perform the operation and push the result.
Return the latest result.
*/
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){return 0;}
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(int i  = 0; i < tokens.length; i++){
            char c = tokens[i].charAt(0);                                               
            if(!stk.isEmpty() && tokens[i].matches("[+-/*]")){                  // If the token matches operator
                int num1 = stk.pop();                                           // Get Operand 1
                int num2 = stk.pop();                                           // Get Operand 2
                if(c == '+') res = num1 + num2;
                else if(c == '-') res = num2 - num1;                                // Match the relevant operator to do the corresponding operation
                else if(c == '*') res = num1 * num2;
                else if(c == '/') res = num2/num1;
            } else{
                res = Integer.parseInt(tokens[i]);                                          // Push the operands
            }
            stk.push(res);                                                      // Push the latest result computed
        }
        return res;
    }
}