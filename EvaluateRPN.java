package CompetitiveCodeing11;

import java.util.Stack;

/*https://leetcode.com/problems/evaluate-reverse-polish-notation/
-------------------------------------------------------------------------------------------------------
Time complexity : o(n) 
space complexity: o(n) 
Did this code run successfully in leetcode : yes
problems faces : no
*/

public class EvaluateRPN {
    
 public int evalRPN(String[] tokens) {
        
        if(tokens == null || tokens.length == 0) return -1;
      
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<tokens.length;i++)
        {
            
           if(tokens[i].equals("+"))
            {
                int num1 = st.pop();
                int num2 = st.pop();
                
                st.push(num1+num2);
            }
             else if(tokens[i].equals("-"))
            {
                int num1 = st.pop();
                int num2 = st.pop();
                
                st.push(num2-num1);
            }
             else if(tokens[i].equals("/"))
            {
                int num1 = st.pop();
                int num2 = st.pop();
                
                st.push(num2/num1);
            }
             else if(tokens[i].equals("*"))
            {
                int num1 = st.pop();
                int num2 = st.pop();
                
                st.push(num1*num2);
            }
            else{
                 st.push(Integer.parseInt(tokens[i]));

            }
            
            
        }
        
        return st.pop();
        
    }

}
