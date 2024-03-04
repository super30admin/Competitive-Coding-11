/*Time Complexity: O(N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Using stack, convert to integer, if operator pop from stack and evaluate. 
Else for digits push it in the stack.

Prob: 150. Evaluate Reverse Polish Notation
*/

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> st = new Stack<Integer>();
        for(String token : tokens){
            if(token.equals("+")) {
                st.add(st.pop() + st.pop());
            }
            else if(token.equals("/")){
                b = st.pop();
                a = st.pop();
                st.add(a / b);
            }
            else if(token.equals("*")){
                st.add(st.pop() * st.pop());
            }
            else if(token.equals("-")){  
                b = st.pop();
                a = st.pop();
                st.add(a - b);
            }   
            else{
                st.add(Integer.parseInt(token));
            } 
        }
        return st.pop();
    }
}