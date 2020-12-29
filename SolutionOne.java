// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes

class SolutionOne {
    public int evalRPN(String[] tokens) {

        int result;

        if(tokens==null ||tokens.length==0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+"))
            {
                int no2 =  stack.pop();
                int no1 =  stack.pop();
                stack.push(no1+no2);
            }
            else if(tokens[i].equals("-"))
            {
                int no2 =  stack.pop();
                int no1 =  stack.pop();
                stack.push(no1-no2);
            }
            else if(tokens[i].equals("*"))
            {
                int no2 =  stack.pop();
                int no1 =  stack.pop();
                stack.push(no1*no2);
            }
            else if(tokens[i].equals("/"))
            {
                int no2 =  stack.pop();
                int no1 =  stack.pop();
                stack.push(no1/no2);
            }
            else
            {
                int element = Integer.parseInt(tokens[i]);
                stack.push(element);
            }
        }

        return stack.pop();

    }
}