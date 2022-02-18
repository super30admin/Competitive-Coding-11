// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Take a stack store the num, when encounter the operators pop the and consider it as second and then pop and condider it as first, then do the first operator second and store back to stack;
// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(st.size() > 1 && tokens[i].equals("+")){
                int s = st.pop();
                int f = st.pop();
                st.push(f+s);
            }else if(st.size() > 1 && tokens[i].equals("-")){
                int s = st.pop();
                int f = st.pop();
                st.push(f-s);
            }else if(st.size() > 1 && tokens[i].equals("*")){
                int s = st.pop();
                int f = st.pop();
                st.push(f*s);
            }else if(st.size() > 1 && tokens[i].equals("/")){
                int s = st.pop();
                int f = st.pop();
                st.push(f/s);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
