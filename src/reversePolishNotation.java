// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
 * if input is number push it on stack, if operator, apply operator on last 2 elements on stack and push result back
 * at the end, result will be on the top of the stack
 *
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> st = new Stack<>();
        
        Set<String> op = new HashSet<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");
        
        for(String s: tokens){
            
            if(op.contains(s)){
                int second = st.pop();
                int first = st.pop();
                
                if(s.equals("+")){
                    st.push(second + first);
                    
                }else if(s.equals("-")){
                    st.push(first - second);
                    
                }else if(s.equals("*")){
                    st.push(second * first);
                } else  if(s.equals("/")){
                    st.push(first / second);
                }
                
            }else {
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        
        return st.pop();
    }
}