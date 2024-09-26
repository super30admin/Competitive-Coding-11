// Time Complexity : O(tokens length)
// Space Complexity : O(tokens length)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st  = new Stack<>();
        for(String str:tokens){
            // System.out.println(st);
            if(str.equals("+")){
                int tmp1 = st.pop();
                int tmp2 = st.pop();
                st.push(tmp1+tmp2);
            } else if(str.equals("-")){
                int tmp1 = st.pop();
                int tmp2 = st.pop();
                st.push(tmp2-tmp1);
            } else if(str.equals("*")){
                int tmp1 = st.pop();
                int tmp2 = st.pop();
                st.push(tmp1*tmp2);
            } else if(str.equals("/")){
                int tmp1 = st.pop();
                int tmp2 = st.pop();
                st.push(tmp2/tmp1);
            } else st.push(Integer.parseInt(str));
        }
        
        
        return st.peek();
    }
}
