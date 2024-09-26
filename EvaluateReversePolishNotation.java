//Problem 145: Evaluate Reverse Polish Notation
//TC:O(n)
//SC: O(Numbers in a string)

import java.util.*;
class Solution145n {
    public int evalRPN(String[] tokens) {
        
        if(tokens==null || tokens.length==0) return 0;
        //TC:O(N) || SC:O(Numbers in a string)
        Stack<Integer> stack = new Stack<>();
        int res =0;
        
        for(int i=0;i<tokens.length;i++){
            
            if(tokens[i].equals("/") || tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-")){
                
                int val2 = stack.pop();
                int val1 = stack.pop();
                
                if(tokens[i].equals("/")) res = val1/val2;
                if(tokens[i].equals("*")) res = val1*val2;
                if(tokens[i].equals("+")) res = val1+val2;
                if(tokens[i].equals("-")) res = val1-val2;
                
                stack.push(res);
                
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
                
        return stack.peek();
    }
}