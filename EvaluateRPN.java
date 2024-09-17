// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(String token: tokens){
            if(token.equals("+")){
                st.push(st.pop() + st.pop());
            }
            else if(token.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }
            else if(token.equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if(token.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }
            else
                st.push(Integer.parseInt(token));
        }
        
        return st.pop();
    }
}