// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack  = new Stack<>();
        for(String s :tokens)
        {
            if(s.matches("-?[0-9]+"))
            {
                Integer x = Integer.parseInt(s);
                stack.push(x);
            }
            else
            {
                int a = stack.pop();
                int b = stack.pop();
                if(s.equals("+"))
                {
                      stack.push(a+b);    
                }
                else if (s.equals("-"))
                {
                     stack.push(b-a);   
                }
                else if (s.equals("*"))
                {
                     stack.push(a*b);   
                }
                else
                {
                     stack.push(b/a);   
                }
            }
        }
        
        return stack.pop();
    }
}class evaluatePOstfix {
    
}