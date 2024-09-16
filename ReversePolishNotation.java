// Time Complexity : O(n) --> where n is the length of input string array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (150): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
       // edge case
        if (tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            if (! "+-*/".contains(tokens[i])) {
                st.push(Integer.valueOf(tokens[i]));
                continue;
            }
            
            int num2 = st.pop();
            int num1 = st.pop();
            
            switch(tokens[i]) {
                case "+":
                    st.push(num1 + num2);
                    break;
                case "-":
                    st.push(num1 - num2);
                    break;
                case "*":
                    st.push(num1 * num2);
                    break;
                case "/":
                    st.push(num1 / num2);
                    break;
            }
        }
        return st.pop();
    }
}