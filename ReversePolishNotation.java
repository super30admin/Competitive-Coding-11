// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++)
        {
                
                switch (tokens[i])
                    {case"+": 
                        s.push(s.pop() + s.pop());
                        break;
                    case"-":
                        s.push(-s.pop() + s.pop());
                        break;
                    case"*":
                        s.push(s.pop() * s.pop());
                        break;
                    case"/":
                            int op2 = s.pop();
                            int op1 = s.pop();
                            s.push(op1/op2);
                        break;
                    default:
                        s.push(Integer.valueOf(tokens[i]));
                    }                     
            }
                
        
        return s.pop();
        
    }
}
