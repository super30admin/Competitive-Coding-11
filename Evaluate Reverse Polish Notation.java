// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Stack

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> stack = new Stack();

        for(int i = 0; i < tokens.length; i++)
        {
            String s = tokens[i];

            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
            {
                stack.push(s);
            }
            else
            {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());

                if(s.equals("+")) stack.push(String.valueOf(y + x));

                else if(s.equals("-")) stack.push(String.valueOf(y - x));

                else if(s.equals("*")) stack.push(String.valueOf(y * x));

                else stack.push(String.valueOf(y / x));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}