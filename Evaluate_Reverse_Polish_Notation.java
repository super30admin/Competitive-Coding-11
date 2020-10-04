import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        //edge case
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            int result = 0;
           
            String ch = tokens[i];
            if(ch.equals("+"))
            {
                result = stack.pop() + stack.pop();
                stack.push(result);
            }else if(ch.equals("-"))
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                result = val2 - val1;
                stack.push(result);
            }else if(ch.equals("*"))
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                result = val1 * val2;
                stack.push(result);
            }else if(ch.equals("/"))
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                result = val2 / val1;
                stack.push(result);
            }else
            {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.pop();
    }
}

//Time complexity: O(n)
//Space complexity: O(n) for the stack