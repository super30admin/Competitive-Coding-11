time complexity- o(n)
space : o(n)
ran on leetcode.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        for(String str : tokens)
        {
            if(!"+-*/".contains(str))
            {stack.push(Integer.valueOf(str));
             continue;
            }
            
            int op2= stack.pop();
            int op1= stack.pop();
            int result =0;
            
            switch(str)
            {
                case "+" : result = op1+op2;
                    break;
                case "-" : result = op1-op2;
                    break;
                case "*" : result = op1*op2;
                    break;
                case "/" : result = op1/op2;
                    break;
            }
            stack.push(result);
            
        }
        
        int result = stack.pop();
        return result;
        
    }
}