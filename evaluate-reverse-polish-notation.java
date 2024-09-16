// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+"))
                stack.push(stack.pop()+stack.pop());
            else if(tokens[i].equals("-"))
                stack.push(-stack.pop()+stack.pop());
            else if(tokens[i].equals("*"))
                stack.push(stack.pop()*stack.pop());
            else if(tokens[i].equals("/"))
            {
                int a=stack.pop(), b=stack.pop();
                stack.push(b/a);
            }
                //stack.push(1/stack.pop()/stack.pop());
            else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
