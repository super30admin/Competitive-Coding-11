// Time Complexity : O(n) n - input array
// Space Complexity : O(n) stack to store Operands
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Used stack to store the integer operand and temp operand variables
// When encountered an operator pop and perform operation, store result back to stack

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0 || tokens == null) return -1;
        Stack<Integer> st = new Stack();
        for(String str:tokens){
            int temp =0;
            if(str.equals("+") && !st.isEmpty()){ 
                temp += st.pop();
                temp += st.pop();
                st.push(temp);
            }
            else if(str.equals("-") && !st.isEmpty()){ 
                int t = st.pop();
                temp = st.pop()-t;
                st.push(temp);
            }
            else if(str.equals("*") && !st.isEmpty()){
                temp = st.pop();
                temp *= st.pop();
                st.push(temp);
            }
            else if(str.equals("/") && !st.isEmpty()){
                int t = st.pop();
                temp = st.pop()/t;
                st.push(temp);
            }
            else{
                st.push(Integer.valueOf(str));
            }
        }
        return !st.isEmpty() ? st.pop() : -1;
    }
}
