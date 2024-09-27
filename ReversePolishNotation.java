// Time Complexity : O(n) where n is the length of the array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * we will process the tokens one by one and for every operand, we just push on the stack
 * For every operator, we will pop two operands from stack and perform the operation
 * After performing the operation, we will push the result to the stack.
 */

class Solution {
    public int evalRPN(String[] nums) {
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<nums.length;i++) {
            String cur = nums[i];
            
            if(cur.equals("+") || cur.equals("*") || cur.equals("/") || cur.equals("-")) {
                int operand1 = st.pop();
                int operand2 = st.pop();
                
                switch(cur) {
                    case "+" : 
                        st.push(operand2 + operand1);
                        break;
                    case "-" :
                        st.push(operand2 - operand1);
                        break;
                    case "*" : 
                        st.push(operand2 * operand1);
                        break;
                    case "/" :
                        st.push(operand2 / operand1);
                        break;
                }
            } else {
                int value = Integer.parseInt(cur);
                st.push(value);
            }
        }
        
        return st.peek();
    }
}    







