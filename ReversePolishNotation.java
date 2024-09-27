
// Time complexity: O(N)
//Space complexity : O(N)

import java.util.*;
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