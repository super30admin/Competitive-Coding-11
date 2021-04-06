// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        int a=0;
        int b=0;
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens){//adding to stack the number and popping only when we see opearns and do operation on top two.
            if(ch.equals("+")){
                b=st.pop();
                a=st.pop();
                st.push(a+b);
            }
            else if(ch.equals("-")){
                b=st.pop();
                a=st.pop();
                st.push(a-b);
            }
             else if(ch.equals("*")){
                b=st.pop();
                a=st.pop();
                st.push(a*b);
            }
            else if(ch.equals("/")){
                b=st.pop();
                a=st.pop();
                st.push(a/b);
            }
            else
            {
                st.push(Integer.parseInt(ch));
            }
        }
        
        return st.pop();
        
    }
}