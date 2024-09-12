// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
        
        int a, b;
        Stack<Integer> s = new Stack<>();
        
        for(String str : tokens) {
            
            if(str.equals("+")) {
                s.push(s.pop() + s.pop());
            }
            else if(str.equals("-")) {
                b = s.pop();
                a = s.pop();
                s.push(a - b);
            }
            else if(str.equals("/")) {
                b = s.pop();
                a = s.pop();
                s.push(a / b);
            }else if(str.equals("*")) {
                s.push(s.pop() * s.pop());
            } else {
                s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
}