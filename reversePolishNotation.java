// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Use stack to keep adding the integers and when an operator is encountered pop the two digits from stack and apply that operation
//Procees this for all the elements in string array
//Return the value present at top of stack
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens) {
            if(token.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            } else if(token.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            } else if(token.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            } else if(token.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            } else {
                //its a number
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
        
    }
}
