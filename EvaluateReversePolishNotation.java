// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use a stack to store the digits and any computed result at each stage to use it again for further calculation.
We first identify if the incoming token is a digit or an operand. If its a digit, we simply push it to the stack.
If its an operand, we need to perform some operation, so we pop the stack twice and do the applicable operation
accoridngly using a switch case and push the corresponding result to the stack again.Finally, we return the
stack's top which ideally holds the overall result.
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens) {
            if(!"+-*/".contains(token)) {
                st.push(Integer.valueOf(token));
                continue;
            }
            int number2 = st.pop();
            int number1 = st.pop();

            int result = 0;

            switch(token) {
                case "+" :
                    result = number1  + number2;
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
            st.push(result);
        }
        return st.pop();
    }
}