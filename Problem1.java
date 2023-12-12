// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a + b);
            }
            else if(token.equals("-")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a - b);
            }
            else if(token.equals("*")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a * b);
            }
            else if(token.equals("/")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a / b);
            }
            else{
                stk.push(Integer.parseInt(token));
            }
            
        }
        return stk.pop();
    }}